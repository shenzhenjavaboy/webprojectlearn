package com.javaman.webprojectlearn.elastic;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpHost;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.lucene.search.TotalHits;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.MatchAllQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.TermQueryBuilder;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ElasticSearch {
    @Test
    void fun2() throws IOException {
        //配置环境
        //如果有账号  密码 配置登录
       /* CredentialsProvider credentialsProvider=new BasicCredentialsProvider();
        credentialsProvider.setCredentials(AuthScope.ANY,
                new UsernamePasswordCredentials("账号", "密码"));*/

        RestHighLevelClient client = new RestHighLevelClient(
                RestClient.builder(
                        new HttpHost("127.0.0.1", 9200, "http")
                )
        );

        //创建连接 配置索引---类似数据库的库名
        SearchRequest searchRequest = new SearchRequest("hello");
        //配置类型 ---类似数据库表名
        searchRequest.types("user");
        //构建搜索条件
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        //分页
        searchSourceBuilder.from(0);//分页起始条数
        searchSourceBuilder.size(10);
        //高亮
        searchSourceBuilder.highlighter();
        //查询条件
        BoolQueryBuilder queryBuilder=QueryBuilders.boolQuery();
        // 查询关键字
        queryBuilder.must(QueryBuilders.wildcardQuery("name", "zhang"));
        // 查询匹配正则
        //queryBuilder.must(QueryBuilders.regexpQuery("name", "[^\\s]+"));
        //查询过滤 某个字段的内容  termquery 是全词匹配
        //queryBuilder.mustNot(QueryBuilders.termQuery("name","空"));
        searchSourceBuilder.query(queryBuilder);
        //设置搜索时间范围  注意gt 带e和不带e 为闭区间 和开区间
        //queryBuilder.must(QueryBuilders.rangeQuery("date").gte("2020-01-01").lt("2021-01-01"));

        //构建搜索
        searchRequest.source(searchSourceBuilder);

        SearchResponse search = client.search(searchRequest, RequestOptions.DEFAULT);
        //获取总条数
        TotalHits totalHits = search.getHits().getTotalHits();
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
