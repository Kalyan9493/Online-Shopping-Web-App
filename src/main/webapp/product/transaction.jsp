<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="css/Transaction.css">
</head>
<body>
<div class="row">
  <div class="col-75">
    <div class="container">
      <form action="/savetransaction" method="post">
      
        <div class="row">

          <div class="col-50">
            <h3>Payment</h3>
            
            <label for="cname">Name on Card</label>
            <input type="text" id="cname" name="name" placeholder="card holder name">
            <label for="ccnum">Credit card number</label>
            <input type="number" id="ccnum" name="cardnumber" placeholder="1111-2222-3333-4444">
            <label for="expmonth">Exp Month/year</label>
            <input type="text" id="expmonth" name="expmonth" placeholder="September/2023">
            <div class="row">
              <div class="col-50">
                <label for="cvv">CVV</label>
                <input type="number" id="cvv" name="cvv" placeholder="352">
              </div>
            </div>
          </div>
          
        </div>
        <input type="submit" value="Continue to payment" class="btn">
      </form>
    </div>
  </div>
</div>
</body>
</html>
