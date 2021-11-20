# About University App
This is an very minimilastic App. It show list of top 50 universities by fetching the data from an API, saves them offline and then displays in RecylerView.
## Library Used
- Retrofit (For all APIs interactions)
- Gson (Converting Java object to JSON)
- Paperdb (Storing the data offline)

## Working
We are building a very basic app to show data via API call, for that we used retrofit to manage all API calls and responses, we stored the responses in ArrayList and then created a custom adapter to bind the data in recycler view. We also stored the data in offline database using Paperdb library so that even if there is no internet connection we may acces the details of universities. The look/UI of the app has been kept default and basic.

## APK Link
https://drive.google.com/file/d/1WtwsCYoJmC34mpi6Ol9IbiJwR56xtTXg/view?usp=sharing
