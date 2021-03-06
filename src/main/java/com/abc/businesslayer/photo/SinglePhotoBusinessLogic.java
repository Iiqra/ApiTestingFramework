package com.abc.businesslayer.photo;

import com.abc.pojo.photo.SinglePhoto;
import com.abc.util.PropertyReader;
import io.restassured.response.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.abc.constant.ServiceConstant.BASE_URL;
import static com.abc.constant.ServiceConstant.PHOTOS_ENDPOINT;
import static io.restassured.RestAssured.when;

public class SinglePhotoBusinessLogic extends PropertyReader {

    private static final Logger log = LoggerFactory.getLogger(SinglePhotoBusinessLogic.class);

    /**
     * Extract data as Response object
     * Populate Single Photo Response POJOs
     * https://jsonplaceholder.typicode.com/photos/1
     *
     * @param id - photo id to fetch a single photo
     */
    public static SinglePhoto getSinglePhotoById(int id) {
        String baseUrl = prop.getProperty(BASE_URL);
        String photosEndpoint = prop.getProperty(PHOTOS_ENDPOINT);
        String url = baseUrl + photosEndpoint + id;
        log.info("URL to be hit : " + url);

        Response response = when().get(url);
        SinglePhoto singlePhoto = response.getBody().as(SinglePhoto.class);
        log.info("Info : " + singlePhoto);
        return singlePhoto;
    }
}
