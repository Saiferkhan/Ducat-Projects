Feature:

   Scenario Outline:
     Given   user open the url
     When   enter the valid <user> and <pass>
     And   press the enter button
     Then home page should display with valid data
     And  Throws erros with invalid data

Example:

|user	 |pass    |status|
|Admin	 |admin123|pass  |
|Admin	 |Admim123|fail	 |
|jack	 |jack123 |fail	 |