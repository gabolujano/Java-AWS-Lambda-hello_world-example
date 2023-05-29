package com.madadipouya.hello.world.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;

public class MainFunction implements RequestHandler<APIGatewayProxyRequestEvent, APIGatewayProxyResponseEvent> {

    public APIGatewayProxyResponseEvent handleRequest(APIGatewayProxyRequestEvent request, Context context) {
        String httpMethod = request.getHttpMethod();
        APIGatewayProxyResponseEvent response = new APIGatewayProxyResponseEvent();

        switch (httpMethod) {
            case "GET":
                response.setStatusCode(200);
                response.setBody("Hello, GET request!");
                break;
            case "POST":
                response.setStatusCode(200);
                response.setBody("Hello, POST request!");
                break;
            // Add cases for other HTTP methods as needed
            case "PATCH":
                response.setStatusCode(200);
                response.setBody("Hello, PATCH request!");
                break;
            // Add cases for other HTTP methods as needed
            default:
                response.setStatusCode(400);
                response.setBody("Unsupported HTTP method: " + httpMethod);
        }

        return response;
    }
}

