package com.kevincode;

import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;
import lombok.Data;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * User: kevin.xie<br/>
 * Date: 08/07/2020<br/>
 * Time: 18:17<br/>
 */
public class UnirestTest {




    public static void main(String[] args) {

        Article article = new Article("11111", "Guide to Rest", "baeldung");
        HttpResponse<JsonNode> jsonNodeHttpResponse =
                Unirest.post("http://www.mocky.io/v2/5a9ce7663100006800ab515d")
                .body(article)
                .asJson();

        System.out.println("Test for: " + jsonNodeHttpResponse.getBody());

        assertEquals(201, jsonNodeHttpResponse.getStatus());

    }

    @Data
    public static class Article {

        public Article(String id, String desc, String name) {
            this.id = id;
            this.desc = desc;
            this.name = name;
        }

        public String id;
        public String desc;
        public String name;
    }


    @Test
    public void shouldReturnStatusOkay() {
        String str
                = Unirest.post("http://127.0.0.1:3002/api/transaction/getCurrencyByName")
                .header("Content-Type", "application/json")
                .field("currencyName", "USD")
                .asString()
                .getBody();
        System.out.println(str);
    }
}
