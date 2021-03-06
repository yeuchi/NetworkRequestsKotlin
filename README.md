# NetworkRequestsKotlin

Network communication has progressed significantly in the last few years. \
This project is a collection of those strategies, old and new for comparison. \
Premise of the exercise is a follows.
- HTTP Get request
- handle JSON conversion to Users
- unit test for each
- basic UI control to execute each strategy.

## Sample data
Using data from Mindorks<sup>[1]</sup>

- BASE URL https://5e510330f2c0d300147c034c.mockapi.io/
- USER users

```
[{"id":"1","name":"Dr. Edwin Orn","avatar":"https://s3.amazonaws.com/uifaces/faces/twitter/sunlandictwin/128.jpg","email":"Connor.Hartmann71@gmail.com"},
{"id":"2","name":"Alford Hoeger","avatar":"https://s3.amazonaws.com/uifaces/faces/twitter/fuck_you_two/128.jpg","email":"Rick83@gmail.com"},
{"id":"3","name":"Terrance Halvorson","avatar":"https://s3.amazonaws.com/uifaces/faces/twitter/mufaddal_mw/128.jpg","email":"Kenton_Wisozk@hotmail.com"},
{"id":"4","name":"Morgan McGlynn","avatar":"https://s3.amazonaws.com/uifaces/faces/twitter/allfordesign/128.jpg","email":"Adah_Streich14@gmail.com"},
{"id":"5","name":"Ms. Ramiro DuBuque","avatar":"https://s3.amazonaws.com/uifaces/faces/twitter/shaneIxD/128.jpg","email":"Forrest_Toy@yahoo.com"},
{"id":"6","name":"Kolby Orn","avatar":"https://s3.amazonaws.com/uifaces/faces/twitter/johnsmithagency/128.jpg","email":"Kay.Kuhn22@yahoo.com"},
{"id":"7","name":"Elijah Schoen MD","avatar":"https://s3.amazonaws.com/uifaces/faces/twitter/alxndrustinov/128.jpg","email":"Mya_Leuschke@yahoo.com"},\
{"id":"8","name":"Colton Kohler","avatar":"https://s3.amazonaws.com/uifaces/faces/twitter/gearpixels/128.jpg","email":"Stephen49@hotmail.com"},
....
```

## View - user interface
Each of the network strategy can be executed individually. \
Number of users loaded is displayed. \
<img width="420" alt="Screen Shot 2020-06-27 at 2 34 04 PM" src="https://user-images.githubusercontent.com/1282659/85933604-82619c00-b89e-11ea-8803-ef2ebf0fdf02.jpg">

## Callback - async task
This is the traditional strategy taught by Google when using Java. \
Detail pattern and source code are available in course: Android Basics : Networking by Google <sup>[4]</sup>

<img width="550" alt="Screen Shot 2020-06-25 at 6 10 54 PM" src="https://user-images.githubusercontent.com/1282659/85805536-3aae0980-b712-11ea-8321-c04ce2fb1720.png">

## Coroutine 
This is the recent design pattern recommended by Google when using Kotlin. \
Example demonstrate the use of corountine with UrlConnection and Scanner. \
This utilize the same traditional code in Callback; replacing the AsyncTask class.

<img width="410" alt="Screen Shot 2020-06-25 at 6 31 53 PM" src="https://user-images.githubusercontent.com/1282659/85805537-3c77cd00-b712-11ea-849f-fe768d6c8b99.png">

## Volley
This is the simple demo code by Google Volley<sup>[5]</sup> 

<img width="390" alt="Screen Shot 2020-06-26 at 3 35 42 PM" src="https://user-images.githubusercontent.com/1282659/85898892-b9fb1600-b7c2-11ea-9d2c-1bdf39f1578a.png">

## RetroFit 2.6 + Coroutine
RetroFit is a popular Network Request library that utilizes OkHttp and Gson. \
Paolo<sup>[3]</sup> offers a nice article on the suspend method.

<img width="590" alt="Screen Shot 2020-06-25 at 6 45 30 PM" src="https://user-images.githubusercontent.com/1282659/85806242-1a7f4a00-b714-11ea-8f8c-069cf03c02fe.png">

## RetroFit + RxAndroid
Same RetroFit as above, working with RxJava library. \
Thanks to Jessica Thornsby article <sup>[6]</sup> for the operators.

<img width="584" alt="Screen Shot 2020-06-27 at 3 16 09 PM" src="https://user-images.githubusercontent.com/1282659/85931324-32c4a580-b889-11ea-8921-062558350419.png">


# Unit Tests
All above strategies have most basic 'happy path' tests.
https://github.com/yeuchi/NetworkRequestsKotlin/tree/master/app/src/androidTest/java/com/ctyeung/networkrequestex

# References

1. Retrofit-Kotlin-Coroutines-Example by Mindorks, April 13, 2020 \
https://github.com/MindorksOpenSource/Retrofit-Kotlin-Coroutines-Example

2. Retrofit by Square, Inc. \
https://square.github.io/retrofit/

3. Suspend what you’re doing: Retrofit has now Coroutines support! by Paolo Rotolo, June 27, 2019 \
https://proandroiddev.com/suspend-what-youre-doing-retrofit-has-now-coroutines-support-c65bd09ba067

4. Android Basics : Network by Google \
Udacity : https://www.udacity.com/course/android-basics-networking--ud843 \
Github (Fetch earthquake data): \
https://github.com/udacity/ud843-QuakeReport/commit/3d6bea42dd2f67d578cfdbede67f802f4b3997a3

5. Google Volley & trainning
https://developer.android.com/training/volley
https://github.com/google/volley

6. Connect to an API With Retrofit, RxJava 2, and Kotlin by Jessica Thornsby, 14 Nov 2018
https://code.tutsplus.com/tutorials/connect-to-an-api-with-retrofit-rxjava-2-and-kotlin--cms-32133
