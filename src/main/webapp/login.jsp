<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/style.css">
    <title>Document</title>
</head>
<body>
    <div class="container">
        <div class="form-container" id="login-form">
          <h1>Login</h1>
          <form action="login" method="post">
            <label for="username">Username</label>
            <input type="text" id="username" name="login_id" required>
            <label for="password">Password</label>
            <input type="password" id="password" name="password" required>
            <button type="submit">Login</button>
          </form>
        </div>
      </div>
</body>
</html>