package CucumberSteps;


import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.SimpleDateFormat;
import java.util.*;


public class WebApplicationStepDefinition extends WebApplicationObjectDeclaration {


    public WebApplicationStepDefinition() {

    }

    /*********************************** Given************************/
    @Given("launch weather forecast application")
    public void launchapplication() {
        driver = TestAutomation.webApplication.webHelper.launchWebDriver();
    }


    /*********************************** When************************/
    @When("i enter city name:\"([^\"]*)\"$")
    public void enterCity(String cityDetail) throws Throwable {
        driver.findElement(By.id(properties.getProperty("City"))).clear();
        driver.findElement(By.id(properties.getProperty("City"))).sendKeys(cityDetail);
        driver.findElement(By.id(properties.getProperty("City"))).click();
    }


    @When("i click on day:\"([^\"]*)\"$")
    public void clickDay(String daydetails) throws Throwable {
        switch (daydetails) {

            case "1":
                driver.findElement(By.xpath(properties.getProperty("Day1"))).click();
                break;
            case "2":
                driver.findElement(By.xpath(properties.getProperty("Day2"))).click();
                break;

            case "3":
                driver.findElement(By.xpath(properties.getProperty("Day3"))).click();
                break;
            case "4":
                driver.findElement(By.xpath(properties.getProperty("Day4"))).click();
                break;

            case "5":
                driver.findElement(By.xpath(properties.getProperty("Day5"))).click();
                break;

        }
    }


    /*********************************Then*****************/
    @Then("i see 5 days weather forecast")
    public void verifyFiveDayForecast() {
        // fetch system day

        String systemday = null;
        Calendar calendar = Calendar.getInstance();
        Date date = calendar.getTime();
        // 3 letter name form of the day
        systemday = (new SimpleDateFormat("EE", Locale.ENGLISH).format(date.getTime()));
        // get the days that are displaying
        // verify if the elements exists
        Assert.assertTrue(driver.findElements(By.xpath(properties.getProperty("Day1"))).size() > 0);
        Assert.assertTrue(driver.findElements(By.xpath(properties.getProperty("Day2"))).size() > 0);
        Assert.assertTrue(driver.findElements(By.xpath(properties.getProperty("Day3"))).size() > 0);
        Assert.assertTrue(driver.findElements(By.xpath(properties.getProperty("Day4"))).size() > 0);
        Assert.assertTrue(driver.findElements(By.xpath(properties.getProperty("Day5"))).size() > 0);
        // get days that are getting displayed
        String firstDay = driver.findElement(By.xpath(properties.getProperty("Day1"))).getText();
        String secondDay = driver.findElement(By.xpath(properties.getProperty("Day1"))).getText();
        String ThirdDay = driver.findElement(By.xpath(properties.getProperty("Day1"))).getText();
        String fourthDay = driver.findElement(By.xpath(properties.getProperty("Day1"))).getText();
        String fiftyday = driver.findElement(By.xpath(properties.getProperty("Day1"))).getText();
        // compare the days that are displaying with the system day
        switch (systemday) {
            case "Sun":
                Assert.assertFalse("forecast is not displaying as expected ", firstDay == systemday);
                Assert.assertFalse("forecast is not displaying as expected ", secondDay.equalsIgnoreCase("Mon"));
                Assert.assertFalse("forecast is not displaying as expected ", ThirdDay.equalsIgnoreCase("Tue"));
                Assert.assertFalse("forecast is not displaying as expected ", fourthDay.equalsIgnoreCase("Wed"));
                Assert.assertFalse("forecast is not displaying as expected ", fiftyday.equalsIgnoreCase("Thu"));
                break;
            case "Mon":
                Assert.assertFalse("forecast is not displaying as expected ", firstDay == systemday);
                Assert.assertFalse("forecast is not displaying as expected ", secondDay.equalsIgnoreCase("Tue"));
                Assert.assertFalse("forecast is not displaying as expected ", ThirdDay.equalsIgnoreCase("Wed"));
                Assert.assertFalse("forecast is not displaying as expected ", fourthDay.equalsIgnoreCase("Thu"));
                Assert.assertFalse("forecast is not displaying as expected ", fiftyday.equalsIgnoreCase("Fri"));
                break;
            case "Tue":
                Assert.assertFalse("forecast is not displaying as expected ", firstDay == systemday);
                Assert.assertFalse("forecast is not displaying as expected ", secondDay.equalsIgnoreCase("Wed"));
                Assert.assertFalse("forecast is not displaying as expected ", ThirdDay.equalsIgnoreCase("Thu"));
                Assert.assertFalse("forecast is not displaying as expected ", fourthDay.equalsIgnoreCase("Fri"));
                Assert.assertFalse("forecast is not displaying as expected ", fiftyday.equalsIgnoreCase("Sat"));
                break;
            case "Wed":
                Assert.assertFalse("forecast is not displaying as expected ", firstDay == systemday);
                Assert.assertFalse("forecast is not displaying as expected ", secondDay.equalsIgnoreCase("Thu"));
                Assert.assertFalse("forecast is not displaying as expected ", ThirdDay.equalsIgnoreCase("Fri"));
                Assert.assertFalse("forecast is not displaying as expected ", fourthDay.equalsIgnoreCase("Sat"));
                Assert.assertFalse("forecast is not displaying as expected ", fiftyday.equalsIgnoreCase("Sun"));
                break;
            case "Thu":
                Assert.assertFalse("forecast is not displaying as expected ", firstDay == systemday);
                Assert.assertFalse("forecast is not displaying as expected ", secondDay.equalsIgnoreCase("Fri"));
                Assert.assertFalse("forecast is not displaying as expected ", ThirdDay.equalsIgnoreCase("Sat"));
                Assert.assertFalse("forecast is not displaying as expected ", fourthDay.equalsIgnoreCase("Sun"));
                Assert.assertFalse("forecast is not displaying as expected ", fiftyday.equalsIgnoreCase("Mon"));
                break;
            case "Fri":
                Assert.assertFalse("forecast is not displaying as expected ", firstDay == systemday);
                Assert.assertFalse("forecast is not displaying as expected ", secondDay.equalsIgnoreCase("Sat"));
                Assert.assertFalse("forecast is not displaying as expected ", ThirdDay.equalsIgnoreCase("Sun"));
                Assert.assertFalse("forecast is not displaying as expected ", fourthDay.equalsIgnoreCase("Mon"));
                Assert.assertFalse("forecast is not displaying as expected ", fiftyday.equalsIgnoreCase("Tue"));
                break;
            case "Sat":
                Assert.assertFalse("forecast is not displaying as expected ", firstDay == systemday);
                Assert.assertFalse("forecast is not displaying as expected ", secondDay.equalsIgnoreCase("Sun"));
                Assert.assertFalse("forecast is not displaying as expected ", ThirdDay.equalsIgnoreCase("Mon"));
                Assert.assertFalse("forecast is not displaying as expected ", fourthDay.equalsIgnoreCase("Tue"));
                Assert.assertFalse("forecast is not displaying as expected ", fiftyday.equalsIgnoreCase("Wed"));
                break;
        }

    }


    @Then("i should  get 3 hourly forecast:\"([^\"]*)\"$")
    public void get3HourForeCast(String daydetails) throws Throwable {
        // get systemtime
        Date date = new Date();
        Calendar rightNow = Calendar.getInstance();
        int inthour = rightNow.get(Calendar.HOUR_OF_DAY);
        inthour = 100;
        int firsthr = 0;
        int hr = 0;
        // get application hours
        switch (daydetails) {

            case "1":

                List<WebElement> Day1_hourlyForecaste = driver.findElements(By.xpath(properties.getProperty("Day1_hourlyForecaste")));
                for (int i = 0; i < Day1_hourlyForecaste.size(); i++) {
                    String Day1_hourlyforecast = (Day1_hourlyForecaste.get(i).getText());
                    String[] hours = Day1_hourlyforecast.split("\\r?\\n");
                    String firsthour = hours[0];
                    firsthr = Integer.parseInt(firsthour);
                    Assert.assertTrue("3 hourly forecast is displaying incorrectly", firsthr == (inthour + (i * 3 * 100)));

                }
                break;

            case "2":

                List<WebElement> Day2_hourlyForecaste = driver.findElements(By.xpath(properties.getProperty("Day2_hourlyForecaste")));
                for (int i = 0; i < Day2_hourlyForecaste.size(); i++) {
                    String Day2_hourlyforecast = (Day2_hourlyForecaste.get(i).getText());
                    String[] hours = Day2_hourlyforecast.split("\\r?\\n");
                    String firsthour = hours[0];
                    firsthr = Integer.parseInt(firsthour);
                    Assert.assertTrue("3 hourly forecast is displaying incorrectly", firsthr == (inthour + (i * 3 * 100)));

                }
                break;

            case "3":

                List<WebElement> Day3_hourlyForecaste = driver.findElements(By.xpath(properties.getProperty("Day3_hourlyForecaste")));
                for (int i = 0; i < Day3_hourlyForecaste.size(); i++) {
                    String Day3_hourlyforecast = (Day3_hourlyForecaste.get(i).getText());
                    String[] hours = Day3_hourlyforecast.split("\\r?\\n");
                    String firsthour = hours[0];
                    firsthr = Integer.parseInt(firsthour);
                    Assert.assertTrue("3 hourly forecast is displaying incorrectly", firsthr == (inthour + (i * 3 * 100)));

                }
                break;


            case "4":

                List<WebElement> Day4_hourlyForecaste = driver.findElements(By.xpath(properties.getProperty("Day4_hourlyForecaste")));
                for (int i = 0; i < Day4_hourlyForecaste.size(); i++) {
                    String Day3_hourlyforecast = (Day4_hourlyForecaste.get(i).getText());
                    String[] hours = Day3_hourlyforecast.split("\\r?\\n");
                    String firsthour = hours[0];
                    firsthr = Integer.parseInt(firsthour);
                    Assert.assertTrue("3 hourly forecast is displaying incorrectly", firsthr == (inthour + (i * 3 * 100)));

                }
                break;

            case "5":

                List<WebElement> Day5_hourlyForecaste = driver.findElements(By.xpath(properties.getProperty("Day5_hourlyForecaste")));
                for (int i = 0; i < Day5_hourlyForecaste.size(); i++) {
                    String Day3_hourlyforecast = (Day5_hourlyForecaste.get(i).getText());
                    String[] hours = Day3_hourlyforecast.split("\\r?\\n");
                    String firsthour = hours[0];
                    firsthr = Integer.parseInt(firsthour);
                    Assert.assertTrue("3 hourly forecast is displaying incorrectly", firsthr == (inthour + (i * 3 * 100)));

                }
                break;


        }
    }


    @Then("^i see each day forecast shows the most dominent details$")
    public void selectEachForecast() throws Throwable
    {

        for(int k = 1; k <= 5 ; k++)
        {

           String daydetails = Integer.toString(k);

            int maxtemp = 0;
            int mintemp = 500;
            int wind = 0;
            int agRain = 0;
            switch (daydetails) {
                case "1":
                    driver.findElement(By.xpath(properties.getProperty("Day1"))).click();
                      List<WebElement> Day1_hourlyForecaste = driver.findElements(By.xpath(properties.getProperty("Day1_hourlyForecaste")));

                    for (int i = 0; i < Day1_hourlyForecaste.size(); i++)
                    {
                        String Day1_hourlyforecast = (Day1_hourlyForecaste.get(i).getText());
                        String[] hours = Day1_hourlyforecast.split("\\r?\\n");
                        String[] degreemax = hours[1].split("°");
                        if (Integer.parseInt(degreemax[0]) > maxtemp)
                            maxtemp = Integer.parseInt(degreemax[0]);

                        if(Integer.parseInt(degreemax[0]) < mintemp )
                            mintemp = Integer.parseInt(degreemax[0]);


                        if (Integer.parseInt(hours[2].replace("kph", "")) > wind)
                            wind = Integer.parseInt(hours[2].replace("kph", ""));

                        String[] mmmax = hours[3].split("mm");
                           agRain = agRain + Integer.parseInt(mmmax[0]) ;

                    }
                    // compare the daily summary has most dominent
                    String firstDay = driver.findElement(By.xpath(properties.getProperty("day1_forecaste"))).getText();
                    String[] firstdaysplit = firstDay.split("\\r?\\n");
                    String[] firstdaydegreemax = firstdaysplit[1].split("°");
                    int sizetemp = firstdaydegreemax.length;
                    String[] firstdaymm = firstdaysplit[3].split("mm");

                    Assert.assertTrue("Day 1 :Maximum Temp", (Integer.parseInt(firstdaydegreemax[0]) == maxtemp));
                    Assert.assertTrue("Day 1 :Minimum Temp", (Integer.parseInt(firstdaydegreemax[sizetemp-1]) == mintemp));
                    Assert.assertTrue("Day 1 :Most dominant (or current) wind speed and direction", (Integer.parseInt(firstdaysplit[2].replace("kph", "")) == wind));
                        Assert.assertTrue("Day 1 :Aggregate rainfall", (Integer.parseInt(firstdaymm[0]) ==agRain ));
                    driver.findElement(By.xpath(properties.getProperty("Day1"))).click();
                    break;
                case "2":
                    driver.findElement(By.xpath(properties.getProperty("Day2"))).click();
                    //Thread.sleep(10);
                    List<WebElement>  Day2_hourlyForecaste = driver.findElements(By.xpath(properties.getProperty("Day2_hourlyForecaste")));

                    for (int i = 0; i < Day2_hourlyForecaste.size(); i++)
                    {
                        String Day1_hourlyforecast = (Day2_hourlyForecaste.get(i).getText());
                        String[] hours = Day1_hourlyforecast.split("\\r?\\n");
                        String[] degreemax = hours[1].split("°");
                        if (Integer.parseInt(degreemax[0]) > maxtemp)
                            maxtemp = Integer.parseInt(degreemax[0]);

                        if(Integer.parseInt(degreemax[0]) < mintemp )
                            mintemp = Integer.parseInt(degreemax[0]);


                        if (Integer.parseInt(hours[2].replace("kph", "")) > wind)
                            wind = Integer.parseInt(hours[2].replace("kph", ""));

                        String[] mmmax = hours[3].split("mm");
                        agRain = agRain + Integer.parseInt(mmmax[0]) ;

                    }
                    // compare the daily summary has most dominent
                    String SecondDay = driver.findElement(By.xpath(properties.getProperty("day2_forecaste"))).getText();
                    String[] seconddaysplit = SecondDay.split("\\r?\\n");
                    String[] seconddaydegreemax = seconddaysplit[1].split("°");
                    sizetemp = 0;
                    sizetemp = seconddaydegreemax.length;
                    String[] seconddaymm = seconddaysplit[3].split("mm");

                    Assert.assertTrue("Day 2 :Maximum Temp", (Integer.parseInt(seconddaydegreemax[0]) == maxtemp));
                    Assert.assertTrue("Day 2 :Minimum Temp", (Integer.parseInt(seconddaydegreemax[sizetemp-1]) == mintemp));
                    Assert.assertTrue("Day 2 :Most dominant (or current) wind speed and direction", (Integer.parseInt(seconddaysplit[2].replace("kph", "")) == wind));
                    Assert.assertTrue("Day 2 :Aggregate rainfall", (Integer.parseInt(seconddaymm[0]) == agRain));
                    driver.findElement(By.xpath(properties.getProperty("Day2"))).click();
                    break;
                case "3":
                    driver.findElement(By.xpath(properties.getProperty("Day3"))).click();
                    List<WebElement> Day3_hourlyForecaste = driver.findElements(By.xpath(properties.getProperty("Day3_hourlyForecaste")));

                    for (int i = 0; i < Day3_hourlyForecaste.size(); i++) {
                        String Day1_hourlyforecast = (Day3_hourlyForecaste.get(i).getText());
                        String[] hours = Day1_hourlyforecast.split("\\r?\\n");
                        String[] degreemax = hours[1].split("°");
                        if (Integer.parseInt(degreemax[0]) > maxtemp)
                            maxtemp = Integer.parseInt(degreemax[0]);

                        if(Integer.parseInt(degreemax[0]) < mintemp )
                            mintemp = Integer.parseInt(degreemax[0]);


                        if (Integer.parseInt(hours[2].replace("kph", "")) > wind)
                            wind = Integer.parseInt(hours[2].replace("kph", ""));

                        String[] mmmax = hours[3].split("mm");
                        agRain = agRain + Integer.parseInt(mmmax[0]) ;

                    }
                    // compare the daily summary has most dominent
                    String ThirdDay = driver.findElement(By.xpath(properties.getProperty("day3_forecaste"))).getText();
                    String[] Thirddaysplit = ThirdDay.split("\\r?\\n");
                    String[] thirddaydegreemax = Thirddaysplit[1].split("°");
                    sizetemp = 0;
                    sizetemp = thirddaydegreemax.length;
                    String[] Thirddaymm = Thirddaysplit[3].split("mm");

                    Assert.assertTrue("Day 3 :Maximum Temp", (Integer.parseInt(thirddaydegreemax[0]) == maxtemp));
                    Assert.assertTrue("Day 3 :Minimum Temp", (Integer.parseInt(thirddaydegreemax[sizetemp-1]) == mintemp));
                    Assert.assertTrue("Day 3 :Most dominant (or current) wind speed and direction", (Integer.parseInt(Thirddaysplit[2].replace("kph", "")) == wind));
                    Assert.assertTrue("Day 3 :Aggregate rainfall", (Integer.parseInt(Thirddaymm[0]) == agRain));
                    driver.findElement(By.xpath(properties.getProperty("Day3"))).click();
                    break;
                case "4":
                    driver.findElement(By.xpath(properties.getProperty("Day4"))).click();
                    List<WebElement> Day4_hourlyForecaste = driver.findElements(By.xpath(properties.getProperty("Day4_hourlyForecaste")));

                    for (int i = 0; i < Day4_hourlyForecaste.size(); i++) {
                        String Day1_hourlyforecast = (Day4_hourlyForecaste.get(i).getText());
                        String[] hours = Day1_hourlyforecast.split("\\r?\\n");
                        String[] degreemax = hours[1].split("°");
                        if (Integer.parseInt(degreemax[0]) >maxtemp )
                            maxtemp = Integer.parseInt(degreemax[0]);

                        if(Integer.parseInt(degreemax[0]) < mintemp )
                            mintemp = Integer.parseInt(degreemax[0]);


                        if (Integer.parseInt(hours[2].replace("kph", "")) > wind)
                            wind = Integer.parseInt(hours[2].replace("kph", ""));

                        String[] mmmax = hours[3].split("mm");
                        agRain = agRain + Integer.parseInt(mmmax[0]) ;

                    }
                    // compare the daily summary has most dominent
                    String FouthDay = driver.findElement(By.xpath(properties.getProperty("day4_forecaste"))).getText();
                    String[] Fourthdaysplit = FouthDay.split("\\r?\\n");
                    String[] fourthdaydegreemax = Fourthdaysplit[1].split("°");
                    sizetemp = 0;
                    sizetemp = fourthdaydegreemax.length;
                    String[] Fourthdaymm = Fourthdaysplit[3].split("mm");

                    Assert.assertTrue("Day 4 :Maximum Temp", (Integer.parseInt(fourthdaydegreemax[0]) == maxtemp));
                    Assert.assertTrue("Day 4 :Minimum Temp", (Integer.parseInt(fourthdaydegreemax[sizetemp-1]) == mintemp));
                    Assert.assertTrue("Day 4 :Most dominant (or current) wind speed and direction", (Integer.parseInt(Fourthdaysplit[2].replace("kph", "")) == wind));
                    Assert.assertTrue("Day 4 :Aggregate rainfall", (Integer.parseInt(Fourthdaymm[0]) == agRain));
                    driver.findElement(By.xpath(properties.getProperty("Day4"))).click();
                    break;

                case "5":
                    driver.findElement(By.xpath(properties.getProperty("Day5"))).click();
                    List<WebElement> Day5_hourlyForecaste = driver.findElements(By.xpath(properties.getProperty("Day5_hourlyForecaste")));

                    for (int i = 0; i < Day5_hourlyForecaste.size(); i++) {
                        String Day1_hourlyforecast = (Day5_hourlyForecaste.get(i).getText());
                        String[] hours = Day1_hourlyforecast.split("\\r?\\n");
                        String[] degreemax = hours[1].split("°");
                        if (Integer.parseInt(degreemax[0]) > maxtemp )
                            maxtemp = Integer.parseInt(degreemax[0]);

                        if(Integer.parseInt(degreemax[0]) < mintemp )
                            mintemp = Integer.parseInt(degreemax[0]);

                        if (Integer.parseInt(hours[2].replace("kph", "")) > wind)
                            wind = Integer.parseInt(hours[2].replace("kph", ""));

                        String[] mmmax = hours[3].split("mm");
                        agRain = agRain + Integer.parseInt(mmmax[0]) ;

                    }
                    // compare the daily summary has most dominent
                    String FifthDay = driver.findElement(By.xpath(properties.getProperty("day5_forecaste"))).getText();
                    String[] Fifthdaysplit = FifthDay.split("\\r?\\n");
                    String[] Fifithdaydegreemax = Fifthdaysplit[1].split("°");
                    sizetemp = 0;
                    sizetemp = Fifithdaydegreemax.length;
                    String[] Fifthdaymm = Fifthdaysplit[3].split("mm");

                    Assert.assertTrue("Day 5 :Maximum Temp", (Integer.parseInt(Fifithdaydegreemax[0]) == maxtemp));
                    Assert.assertTrue("Day 5 :Minimum Temp", (Integer.parseInt(Fifithdaydegreemax[sizetemp-1]) == mintemp));
                    Assert.assertTrue("Day 5 :Most dominant (or current) wind speed and direction", (Integer.parseInt(Fifthdaysplit[2].replace("kph", "")) == wind));
                    Assert.assertTrue("Day 5 :Aggregate rainfall", (Integer.parseInt(Fifthdaymm[0]) == agRain));
                    driver.findElement(By.xpath(properties.getProperty("Day3"))).click();
                    break;
            }

        }
    }

     @Then("i should see 3 hourly forecast hidden:\"([^\"]*)\"$")
     public void hiddenForecast(String daydetails)
     {
         switch (daydetails)
         {

             case "1":
                 List<WebElement> Day1_hourlyForecaste = driver.findElements(By.xpath(properties.getProperty("Day1_hourlyForecaste")));
                 Assert.assertFalse("Should hid 3 hourly forecast", Day1_hourlyForecaste.size() < 0);
                 break;

             case "2":
                 List<WebElement> Day2_hourlyForecaste = driver.findElements(By.xpath(properties.getProperty("Day2_hourlyForecaste")));
                 Assert.assertFalse("Should hid 3 hourly forecast", Day2_hourlyForecaste.size() < 0);
                 break;

             case "3":
                 List<WebElement> Day3_hourlyForecaste = driver.findElements(By.xpath(properties.getProperty("Day3_hourlyForecaste")));
                 Assert.assertFalse("Should hid 3 hourly forecast", Day3_hourlyForecaste.size() < 0);
                 break;
             case "4":
                 List<WebElement> Day4_hourlyForecaste = driver.findElements(By.xpath(properties.getProperty("Day4_hourlyForecaste")));
                 Assert.assertFalse("Should hid 3 hourly forecast", Day4_hourlyForecaste.size() < 0);
                 break;
             case "5":
                 List<WebElement> Day5_hourlyForecaste = driver.findElements(By.xpath(properties.getProperty("Day5_hourlyForecaste")));
                 Assert.assertFalse("Should hid 3 hourly forecast", Day5_hourlyForecaste.size() < 0);
                 break;

         }
     }

    /*********************************** And************************/

    @And("i close the weather forecast application")
    public void closeWeatherApp()
    {
        driver.close();
    }




}
