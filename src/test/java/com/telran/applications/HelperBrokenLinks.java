package com.telran.applications;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

public class HelperBrokenLinks extends HelperBase {
    public HelperBrokenLinks(WebDriver wd) {
        super(wd);
    }

    public void selectItemElements() {
        click(By.xpath("//div[@class='category-cards']//h5[text()='Elements']"));

    }

    public void selectBrokenLinksImages() {

        click(By.xpath("//span[.='Broken Links - Images']"));

    }

    public void selectLinks() {
        hideFooter();
        click(By.xpath("//span[.='Links']"));
    }


    public void checkAllUrl() {
        String url = "";
        List<WebElement> allLinks = wd.findElements(By.tagName("a"));
        System.out.println("Total links on the Wb Page: " + allLinks.size());

        Iterator<WebElement> iterator = allLinks.iterator();

        while (iterator.hasNext()) {
            url = iterator.next().getText();
            System.out.println(url);
        }
    }

    public void checkBrokenLinks() {
        List<WebElement> links = wd.findElements(By.tagName("a"));

        for (int i = 0; i < links.size(); i++) {
            WebElement E1 = links.get(i);
            String url = E1.getAttribute("href");
            verifyLinksOkHttp(url);
        }
    }

    private void verifyLinks(String linkUrl) {
        try {
            URL url = new URL(linkUrl);

            //Now we will be creating url connection and getting the response code
            HttpURLConnection httpURLConnect = (HttpURLConnection) url.openConnection();
            httpURLConnect.setConnectTimeout(5000);
            httpURLConnect.connect();
            if (httpURLConnect.getResponseCode() >= 400) {
                System.out.println(linkUrl + " - " + httpURLConnect.getResponseMessage() + "is a broken link");
            } else {
                System.out.println(linkUrl + " - " + httpURLConnect.getResponseMessage());
            }
        } catch (Exception e) {
            System.out.println(linkUrl + " - " + e.getMessage() + " - is a broken link");
        }

    }

    private void verifyLinksOkHttp(String linkUrl) {
        OkHttpClient client = new OkHttpClient();
        try {
            Request request = new Request.Builder()
                    .url(linkUrl)
                    .build();

            Response response = client.newCall(request).execute();
            if (response.isSuccessful()) {
                System.out.println(linkUrl + " - " + response.code() + " " + response.message());
            } else {
                System.out.println(linkUrl + " - " + response.code() + " " + response.message() + " is a broken link");
            }
        }catch (Exception e){
            System.out.println(linkUrl + " - " + e.getMessage() + " - is a broken link");
        }
    }


    public void checkBrokenImages() {
        List<WebElement> images = wd.findElements(By.tagName("img"));

        System.out.println("We have " + images.size() + " " + "images");
        //checking the links fetched.

        for (int index = 0; index < images.size(); index++) {

            WebElement image = images.get(index);
            String imageURL = image.getAttribute("src");
            System.out.println("URL of Image " + (index + 1) + " is: " + imageURL);
            verifyLinksOkHttp(imageURL);

            //Validate image display using JavaScript executor
            try {
                boolean imageDisplayed = (Boolean) ((JavascriptExecutor) wd)
                        .executeScript("return (typeof arguments[0].naturalWidth !=undefined && arguments[0].naturalWidth > 0);", image);
                if (imageDisplayed) {
                    System.out.println("DISPLAY - OK");
                    System.out.println("*******************");
                } else {
                    System.out.println("DISPLAY - BROKEN");
                    System.out.println("*******************");
                }
            } catch (Exception e) {
                System.out.println("Error Occured");
            }
        }
    }

}



//        200 – Valid Link/success
//        301/302 – Page redirection temporary/permanent
//        404 – Page not found
//        400 – Bad request
//        401 – Unauthorized
//        500 – Internal Server Error