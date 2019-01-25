## Quick Start Example

The SDK needs to be instantiated using your API username and API password, which you can get from your [Pesamoni business account](https://pesamoni.com/business/dash).

You can register a new Pesamoni business account [Here](https://pesamoni.com/businesses/sign_up) or Sign in [Here](https://pesamoni.com/businesses/sign_in)


```java

public class DefaultApiExample {

    public static void main(String[] args) {
        DefaultApi apiInstance = new DefaultApi();
```
### Accepting funds from mobile subscriber
```java
        //  you can either use method acreceive or acreceivekeac as explained below
        //  method acreceive
        // This method enables you receive funds from a mobile subscriber in your registered native currency on the Pesamoni platform. If for instance your account is registered in currency UGX and you request money from a Kenyan number e.g 254712346789, a Pesamoni exchange rate will automatically be applied and money deposited into your Pesamoni wallet in your default currency
        //  method acreceivekeac
        //  You can have two native currencies on your Pesamoni account on request. If you would like to deposit funds from a mobile subscriber to your Kenyan Pesamoni wallet account then this is the method you use.
        //  example
        String method = "acreceive"; // String | Enter a request method.
        String amount = "amount_example"; // String | Enter the amount you would like to request for. <p style=\"color:red\">This method applies for request methods <b>acreceive, acreceivekeac, acsend, acsendkeac, acsendbank, pesab2c, sendairtime, cardaccept</b></p>
        String mobile = "mobile_example"; // String | Enter the mobile number you would like to execute the above method in format 256.... or 254...<p style=\"color:red\">This method applies for request methods <b>acreceive, acreceivekeac, acsend, acsendkeac, senderid, sendsms, sendairtime</b></p>
        String reference = "reference_example"; // String | Enter your user generated transaction reference<p style=\"color:red\">This method applies for request methods <b>acreceive, acreceivekeac, acsend, acsendkeac, sendsms, transactionstatus, sendairtime, pesab2c, sendsms, cardaccept</b></p>
        String genericmsg = "genericmsg_example"; // String | Enter your user generated generic message for the requested transaction<p style=\"color:red\">This method applies for request methods <b>acreceive, acreceivekeac, acsend, acsendkeac, sendsms, sendairtime, pesab2c, sendsms, cardaccept</b></p>
        String token = "token_example"; // String | Enter your user generated token for the above mentioned method<p style=\"color:red\">This method applies for request methods <b>acreceive, acreceivekeac, acsend, acsendkeac, sendsms, sendairtime, pesab2c, sendsms, cardaccept</b></p>

            try {
                    InlineResponse200 result = apiInstance.transactionsPost(method, amount, mobile, holdername, cardnumber, cvv, exp, currency, account, reference, genericmsg, token, bouquet, payoption, meternumber);
                    System.out.println(result);
                } catch (ApiException e) {
                    System.err.println("Exception when calling DefaultApi#transactionsPost");
                    e.printStackTrace();
                }

```
### Sending funds to a mobile subscriber

```java
        // you can either use method acreceive or acreceivekeac as explained below
        // acsend
        // This method enables you send funds to a mobile subscriber in your registered native currency on the Pesamoni platform. If for instance your account is registered in currency UGX and you send money to a kenyan number e.g 254712346789, a Pesamoni exchange rate will automatically be applied and the equivalent exchange amount deducted from your Pesamoni wallet in your default currency
        // acsendkeac
        // You can have two native currencies on your Pesamoni account on request. If you would like to send funds from your Pesamoni wallet to a mobile subscriber from your Kenyan Pesamoni wallet account then this is the method you use.
        String method = "acsend"; // String | Enter a request method. To check for request methods <a href=''>click here</a>
        String amount = "amount_example"; // String | Enter the amount you would like to request for. <p style=\"color:red\">This method applies for request methods <b>acreceive, acreceivekeac, acsend, acsendkeac, acsendbank, pesab2c, sendairtime, cardaccept</b></p>
        String mobile = "mobile_example"; // String | Enter the mobile number you would like to execute the above method in format 256.... or 254...<p style=\"color:red\">This method applies for request methods <b>acreceive, acreceivekeac, acsend, acsendkeac, senderid, sendsms, sendairtime</b></p>
        String reference = "reference_example"; // String | Enter your user generated transaction reference<p style=\"color:red\">This method applies for request methods <b>acreceive, acreceivekeac, acsend, acsendkeac, sendsms, transactionstatus, sendairtime, pesab2c, sendsms, cardaccept</b></p>
        String genericmsg = "genericmsg_example"; // String | Enter your user generated generic message for the requested transaction<p style=\"color:red\">This method applies for request methods <b>acreceive, acreceivekeac, acsend, acsendkeac, sendsms, sendairtime, pesab2c, sendsms, cardaccept</b></p>
        String token = "token_example"; // String | Enter your user generated token for the above mentioned method<p style=\"color:red\">This method applies for request methods <b>acreceive, acreceivekeac, acsend, acsendkeac, sendsms, sendairtime, pesab2c, sendsms, cardaccept</b></p>
                try {
                    InlineResponse200 result = apiInstance.transactionsPost(method, amount, mobile, holdername, cardnumber, cvv, exp, currency, account, reference, genericmsg, token, bouquet, payoption, meternumber);
                    System.out.println(result);
                } catch (ApiException e) {
                    System.err.println("Exception when calling DefaultApi#transactionsPost");
                    e.printStackTrace();
                }

```

### Accepting Card Payments e.g VISA/MASTERCARD

```java
        String method = "cardaccept"; // String | Enter a request method. To check for request methods <a href=''>click here</a>
        String amount = "amount_example"; // String | Enter the amount you would like to request for. <p style=\"color:red\">This method applies for request methods <b>acreceive, acreceivekeac, acsend, acsendkeac, acsendbank, pesab2c, sendairtime, cardaccept</b></p>
        String holdername = "holdername_example"; // String | Enter name of payer for Visa/MasterCard transactions<p style=\"color:red\">This method applies for request method <b>cardaccept</b></p>
        String cardnumber = "cardnumber_example"; // String | Enter the Visa/MasterCard cardnumber<p style=\"color:red\">This method applies for request method <b>cardaccept</b></p>
        String cvv = "cvv_example"; // String | Enter the Visa/MasterCard cvv<p style=\"color:red\">This method applies for request method <b>cardaccept</b></p>
        String exp = "exp_example"; // String | Enter the Visa/MasterCard expiry date in the format MM/YYYY e.g 07/2030<p style=\"color:red\">This method applies for request method <b>cardaccept</b></p>
        String currency = "currency_example"; // String | Enter the currency you intend to make the transaction for Visa/MasterCard based transactions<p style=\"color:red\">This method applies for request method <b>cardaccept</b></p>
        String reference = "reference_example"; // String | Enter your user generated transaction reference<p style=\"color:red\">This method applies for request methods <b>acreceive, acreceivekeac, acsend, acsendkeac, sendsms, transactionstatus, sendairtime, pesab2c, sendsms, cardaccept</b></p>
        String genericmsg = "genericmsg_example"; // String | Enter your user generated generic message for the requested transaction<p style=\"color:red\">This method applies for request methods <b>acreceive, acreceivekeac, acsend, acsendkeac, sendsms, sendairtime, pesab2c, sendsms, cardaccept</b></p>
        String token = "token_example"; // String | Enter your user generated token for the above mentioned method<p style=\"color:red\">This method applies for request methods <b>acreceive, acreceivekeac, acsend, acsendkeac, sendsms, sendairtime, pesab2c, sendsms, cardaccept</b></p>
        try {
            InlineResponse200 result = apiInstance.transactionsPost(method, amount, mobile, holdername, cardnumber, cvv, exp, currency, account, reference, genericmsg, token, bouquet, payoption, meternumber);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling DefaultApi#transactionsPost");
            e.printStackTrace();
        }
```

### Bank Transfers

```java
         // you can either use method acsendbank or acsendbankeac as explained below
        // acsendbank
        // This method enables you send funds to a users bank account. A Pesamoni exchange rate will automatically be applied and the equivalent exchange amount deposited to your bank account dependent on your default currency.
        // acsendbankeac
        // You can have two native currencies on your Pesamoni account on request. If you would like to send funds from your Pesamoni wallet to a mobile subscriber from your Kenyan Pesamoni wallet account then this is the method you use.
        String method = "acsendbank"; // String | Enter a request method. To check for request methods <a href=''>click here</a>
        String amount = "amount_example"; // String | Enter the amount you would like to request for. <p style=\"color:red\">This method applies for request methods <b>acreceive, acreceivekeac, acsend, acsendkeac, acsendbank, pesab2c, sendairtime, cardaccept</b></p>
        String account = "account_example"; // String | Enter the Pesamoni account you would like to use for this transaction<p style=\"color:red\">This method applies for request method <b>paybills</b></p>
        String reference = "reference_example"; // String | Enter your user generated transaction reference<p style=\"color:red\">This method applies for request methods <b>acreceive, acreceivekeac, acsend, acsendkeac, sendsms, transactionstatus, sendairtime, pesab2c, sendsms, cardaccept</b></p>
        String genericmsg = "genericmsg_example"; // String | Enter your user generated generic message for the requested transaction<p style=\"color:red\">This method applies for request methods <b>acreceive, acreceivekeac, acsend, acsendkeac, sendsms, sendairtime, pesab2c, sendsms, cardaccept</b></p>
        String token = "token_example"; // String | Enter your user generated token for the above mentioned method<p style=\"color:red\">This method applies for request methods <b>acreceive, acreceivekeac, acsend, acsendkeac, sendsms, sendairtime, pesab2c, sendsms, cardaccept</b></p>
        try {
            InlineResponse200 result = apiInstance.transactionsPost(method, amount, mobile, holdername, cardnumber, cvv, exp, currency, account, reference, genericmsg, token, bouquet, payoption, meternumber);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling DefaultApi#transactionsPost");
            e.printStackTrace();
        }
```

### Sending Airtime to a mobile subsriber

```java
        String method = "sendairtime"; // String | Enter a request method. To check for request methods <a href=''>click here</a>
        String amount = "amount_example"; // String | Enter the amount you would like to request for. <p style=\"color:red\">This method applies for request methods <b>acreceive, acreceivekeac, acsend, acsendkeac, acsendbank, pesab2c, sendairtime, cardaccept</b></p>
        String mobile = "mobile_example"; // String | Enter the mobile number you would like to execute the above method in format 256.... or 254...<p style=\"color:red\">This method applies for request methods <b>acreceive, acreceivekeac, acsend, acsendkeac, senderid, sendsms, sendairtime</b></p>
        String reference = "reference_example"; // String | Enter your user generated transaction reference<p style=\"color:red\">This method applies for request methods <b>acreceive, acreceivekeac, acsend, acsendkeac, sendsms, transactionstatus, sendairtime, pesab2c, sendsms, cardaccept</b></p>
        String genericmsg = "genericmsg_example"; // String | Enter your user generated generic message for the requested transaction<p style=\"color:red\">This method applies for request methods <b>acreceive, acreceivekeac, acsend, acsendkeac, sendsms, sendairtime, pesab2c, sendsms, cardaccept</b></p>
        String token = "token_example"; // String | Enter your user generated token for the above mentioned method<p style=\"color:red\">This method applies for request methods <b>acreceive, acreceivekeac, acsend, acsendkeac, sendsms, sendairtime, pesab2c, sendsms, cardaccept</b></p>
        try {
            InlineResponse200 result = apiInstance.transactionsPost(method, amount, mobile, holdername, cardnumber, cvv, exp, currency, account, reference, genericmsg, token, bouquet, payoption, meternumber);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling DefaultApi#transactionsPost");
            e.printStackTrace();
        }
```

### Sending to a Pesamoni users wallet

```java
        String method = "pesab2c"; // String | Enter a request method. To check for request methods <a href=''>click here</a>
        String amount = "amount_example"; // String | Enter the amount you would like to request for. <p style=\"color:red\">This method applies for request methods <b>acreceive, acreceivekeac, acsend, acsendkeac, acsendbank, pesab2c, sendairtime, cardaccept</b></p>
        String account = "account_example"; // String | Enter the Pesamoni account you would like to use for this transaction<p style=\"color:red\">This method applies for request method <b>paybills</b></p>
        String reference = "reference_example"; // String | Enter your user generated transaction reference<p style=\"color:red\">This method applies for request methods <b>acreceive, acreceivekeac, acsend, acsendkeac, sendsms, transactionstatus, sendairtime, pesab2c, sendsms, cardaccept</b></p>
        String genericmsg = "genericmsg_example"; // String | Enter your user generated generic message for the requested transaction<p style=\"color:red\">This method applies for request methods <b>acreceive, acreceivekeac, acsend, acsendkeac, sendsms, sendairtime, pesab2c, sendsms, cardaccept</b></p>
        String token = "token_example"; // String | Enter your user generated token for the above mentioned method<p style=\"color:red\">This method applies for request methods <b>acreceive, acreceivekeac, acsend, acsendkeac, sendsms, sendairtime, pesab2c, sendsms, cardaccept</b></p>
        try {
            InlineResponse200 result = apiInstance.transactionsPost(method, amount, mobile, holdername, cardnumber, cvv, exp, currency, account, reference, genericmsg, token, bouquet, payoption, meternumber);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling DefaultApi#transactionsPost");
            e.printStackTrace();
        }
```

### Paying Utility Bills

```java
        String method = "paybills"; // String | Enter a request method. To check for request methods <a href=''>click here</a>
        String amount = "amount_example"; // String | Enter the amount you would like to request for. <p style=\"color:red\">This method applies for request methods <b>acreceive, acreceivekeac, acsend, acsendkeac, acsendbank, pesab2c, sendairtime, cardaccept</b></p>
        String mobile = "mobile_example"; // String | Enter the mobile number you would like to execute the above method in format 256.... or 254...<p style=\"color:red\">This method applies for request methods <b>acreceive, acreceivekeac, acsend, acsendkeac, senderid, sendsms, sendairtime</b></p>
        String currency = "currency_example"; // String | Enter the currency you intend to make the transaction for Visa/MasterCard based transactions<p style=\"color:red\">This method applies for request method <b>cardaccept</b></p>
        String account = "account_example"; // String | Enter the Pesamoni account you would like to use for this transaction<p style=\"color:red\">This method applies for request method <b>paybills</b></p>
        String reference = "reference_example"; // String | Enter your user generated transaction reference<p style=\"color:red\">This method applies for request methods <b>acreceive, acreceivekeac, acsend, acsendkeac, sendsms, transactionstatus, sendairtime, pesab2c, sendsms, cardaccept</b></p>
        String genericmsg = "genericmsg_example"; // String | Enter your user generated generic message for the requested transaction<p style=\"color:red\">This method applies for request methods <b>acreceive, acreceivekeac, acsend, acsendkeac, sendsms, sendairtime, pesab2c, sendsms, cardaccept</b></p>
        String token = "token_example"; // String | Enter your user generated token for the above mentioned method<p style=\"color:red\">This method applies for request methods <b>acreceive, acreceivekeac, acsend, acsendkeac, sendsms, sendairtime, pesab2c, sendsms, cardaccept</b></p>
        String bouquet = "bouquet_example"; // String | Enter the bouquet or package you would like to pay for<p style=\"color:red\">This method applies for request methods <b>paybills</b></p>
        String payoption = "payoption_example"; // String | Enter your prefered payment option<p style=\"color:red\">This method applies for request methods <b>paybills</b></p>
        String meternumber = "meternumber_example"; // String | Enter the meter number for the intended payment<p style=\"color:red\">This method applies for request methods <b>paybills</b></p>
        try {
            InlineResponse200 result = apiInstance.transactionsPost(method, amount, mobile, holdername, cardnumber, cvv, exp, currency, account, reference, genericmsg, token, bouquet, payoption, meternumber);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling DefaultApi#transactionsPost");
            e.printStackTrace();
        }
```

### Checking transaction status

```java
        String method = "transactionstatus"; // String | Enter a request method. To check for request methods <a href=''>click here</a>
        String reference = "reference_example"; // String | Enter your user generated transaction reference<p style=\"color:red\">This method applies for request methods <b>acreceive, acreceivekeac, acsend, acsendkeac, sendsms, transactionstatus, sendairtime, pesab2c, sendsms, cardaccept</b></p>
        try {
            InlineResponse200 result = apiInstance.transactionsPost(method, amount, mobile, holdername, cardnumber, cvv, exp, currency, account, reference, genericmsg, token, bouquet, payoption, meternumber);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling DefaultApi#transactionsPost");
            e.printStackTrace();
        }
```

### Checking your Pesamoni Business Wallet Balance

```java
        String method = "acbalance"; // String | Enter a request method. To check for request methods <a href=''>click here</a>
    try {
            InlineResponse200 result = apiInstance.transactionsPost(method, amount, mobile, holdername, cardnumber, cvv, exp, currency, account, reference, genericmsg, token, bouquet, payoption, meternumber);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling DefaultApi#transactionsPost");
            e.printStackTrace();
        }
```

## Sending SMS to a mobile subscriber

```java
        String method = "sendsms"; // String | Enter a request method. To check for request methods <a href=''>click here</a>
        
        String mobile = "mobile_example"; // String | Enter the mobile number you would like to execute the above method in format 256.... or 254...<p style=\"color:red\">This method applies for request methods <b>acreceive, acreceivekeac, acsend, acsendkeac, senderid, sendsms, sendairtime</b></p>
        String reference = "reference_example"; // String | Enter your user generated transaction reference<p style=\"color:red\">This method applies for request methods <b>acreceive, acreceivekeac, acsend, acsendkeac, sendsms, transactionstatus, sendairtime, pesab2c, sendsms, cardaccept</b></p>
        String genericmsg = "genericmsg_example"; // String | Enter your user generated generic message for the requested transaction<p style=\"color:red\">This method applies for request methods <b>acreceive, acreceivekeac, acsend, acsendkeac, sendsms, sendairtime, pesab2c, sendsms, cardaccept</b></p>
        String token = "token_example"; // String | Enter your user generated token for the above mentioned method<p style=\"color:red\">This method applies for request methods <b>acreceive, acreceivekeac, acsend, acsendkeac, sendsms, sendairtime, pesab2c, sendsms, cardaccept</b></p>
        String message = "message_example"; // # String | Enter your message <p style=\"color:red\">This method applies for request methods <b>sendsms</b></p>
        try {
            InlineResponse200 result = apiInstance.transactionsPost(method, amount, mobile, holdername, cardnumber, cvv, exp, currency, account, reference, genericmsg, token, bouquet, payoption, meternumber);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling DefaultApi#transactionsPost");
            e.printStackTrace();
        }
    
```

## Documentation for API Endpoints

All Endpoint URIs are relative to https://pesamoni.com/api/live/v1/transactions


## Contributing

Bug reports and pull requests are welcome on GitHub at https://github.com/Pesamoni.

## License

The Android Api library is available as open source under the terms of the [Apache License 2.0](https://www.apache.org/licenses/LICENSE-2.0).

### Authentication schemes defined for the API:
### apipassword

- **Type**: API key
- **API key parameter name**: apipassword
- **Location**: URL query string

### apiusername

- **Type**: API key
- **API key parameter name**: apiusername
- **Location**: URL query string