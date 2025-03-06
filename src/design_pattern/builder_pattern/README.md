# Builder Pattern
- Creational Design Pattern
- Construct complex objects step by step
- Promotes immutability, readability, and flexibility

## Complex Object Construction
```java
Car myCar = new Car.Builder()
                .setMake("Toyota")
                .setModel("Camry")
                .setYear(2022)
                .setColor("Red")
                .setHasSunroof(true)
                .build(); 
```


## GUI Frameworks and UI Construction
```java
    Form form = new Form.Builder()
            .setTitle("Sign-Up Form")
            .setSubmitButtonText("Submit")
            .addInputField("Username")
            .addInputField("Password")
            .addInputField("Email")
            .build();
```

## Database Query Builders
```java
    SqlQuery query = new SqlQuery.Builder()
        .setTable("users")
        .addColumn("name")
        .addColumn("email")
        .setWhereCondition("age > 30")
        .build();
```

## Configuration Setup
```java
    AppConfig config = new AppConfig.Builder()
        .setDatabaseUrl("jdbc:mysql://localhost:3306/mydb")
        .setDatabaseUsername("root")
        .setDatabasePassword("password")
        .setEnableLogging(true)
        .build();
```

## API Response Construction
```java
ApiResponse response = new ApiResponse.Builder()
        .seStatusCode(200)
        .setMessage("Request Successful")
        .setData(new Object())
        .build();
```