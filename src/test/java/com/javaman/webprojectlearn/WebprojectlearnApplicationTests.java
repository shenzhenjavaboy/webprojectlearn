package com.javaman.webprojectlearn;



import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpHost;

import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.elasticsearch.index.query.MatchAllQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.TermQueryBuilder;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@SpringBootTest
class WebprojectlearnApplicationTests {

    @Test
    void contextLoads() {
        System.out.println("hello");
    }


    @Test
    void testCreateIndex() throws IOException {

        RestHighLevelClient client = new RestHighLevelClient(
                RestClient.builder(
                        new HttpHost("127.0.0.1", 9200, "http")
                )
        );
        //1.创建索引请求
        CreateIndexRequest request = new CreateIndexRequest("joker_index");
        //2.执行创建请求
        CreateIndexResponse createIndexResponse = client.indices().create(request,
                RequestOptions.DEFAULT);
        System.out.println(createIndexResponse);

    }

    @Test
    void fun2() throws IOException {
        //配置环境
        RestHighLevelClient client = new RestHighLevelClient(
                RestClient.builder(
                        new HttpHost("127.0.0.1", 9200, "http")
                )
        );

        SearchRequest searchRequest = new SearchRequest("hello");
        //构建搜索条件
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        //分页
        searchSourceBuilder.from(0);
        searchSourceBuilder.size(3);
        //高亮
        searchSourceBuilder.highlighter();
        //查询条件
        MatchAllQueryBuilder matchAllQueryBuilder = QueryBuilders.matchAllQuery();
        TermQueryBuilder termQueryBuilder = QueryBuilders.termQuery("name", "zhangsan");
        searchSourceBuilder.query(matchAllQueryBuilder);
        //构建搜索
        searchRequest.source(searchSourceBuilder);

        SearchResponse search = client.search(searchRequest, RequestOptions.DEFAULT);
        System.out.println(JSONObject.toJSONString(search.getHits()));
        System.out.println("**********");
       // Map<String,Object> map=null;
        List<Map<String,Object>> list=new ArrayList<>();
        for (SearchHit hit:search.getHits().getHits()){
            System.out.println(hit.getSourceAsMap());
            list.add(hit.getSourceAsMap());
        }
        System.out.println("////////////");
        //System.out.println(list);
        List<Object> liststr=new ArrayList<>();
        for (Map<String,Object> dataMap:list) {
            for(Map.Entry<String, Object> entry:dataMap.entrySet())
            {
                if (entry.getKey().equals("name")){
                    liststr.add(entry.getValue().toString());
                }
            }
        }



        System.out.println("str,.....");
        System.out.println(liststr);
    }

}
