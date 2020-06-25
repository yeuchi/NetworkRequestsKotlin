# NetworkRequestsKotlin

Network communication has progressed significantly in the last few years.
This repository is a collection of those strategies, old and new.

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

## Callback - async task
This is the traditional strategy taught by Google when using Java. \
Detail pattern and source code are available in course: Android Basics : Networking by Google <sup>[4]</sup>

<img width="663" alt="Screen Shot 2020-06-25 at 6 10 54 PM" src="https://user-images.githubusercontent.com/1282659/85805536-3aae0980-b712-11ea-8321-c04ce2fb1720.png">

## Coroutine 
This is the recent design pattern recommended by Google when using Kotlin. \
Example demonstrate the use of corountine with UrlConnection and Scanner. \
This utilize the same traditional code in Callback; replacing the AsyncTask class.

<img width="410" alt="Screen Shot 2020-06-25 at 6 31 53 PM" src="https://user-images.githubusercontent.com/1282659/85805537-3c77cd00-b712-11ea-849f-fe768d6c8b99.png">

## RetroFit 2.6 + Coroutine
RetroFit is a popular Network Request library that utilizes OkHttp and Gson. \
Paolo<sup>[3]</sup> offers a nice article on the suspend method.

<img width="590" alt="Screen Shot 2020-06-25 at 6 42 27 PM" src="https://user-images.githubusercontent.com/1282659/85806071-aa70c400-b713-11ea-863e-bd3530360dd3.png">


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
