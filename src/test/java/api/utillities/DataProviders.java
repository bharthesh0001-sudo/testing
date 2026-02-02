package api.utillities;


import org.testng.annotations.DataProvider;

public class DataProviders {

    @DataProvider(name = "UserData")
    public String[][] getUserData() throws Exception {

        String path = System.getProperty("user.dir") + "/src/test/resources/TestData/UserData.xlsx";
        XLUtility xl = new XLUtility(path);

        int rowCount = xl.getRowCount("Users");
        int colCount = xl.getCellCount("Users", 1);

        String[][] userData = new String[rowCount][colCount];

        for (int i = 1; i <= rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                userData[i - 1][j] = xl.getCellData("Users", i, j);
            }
        }
        return userData;
    }

        // DataProvider ONLY for username
        @DataProvider(name = "userName")
        public String[] getUserNames() throws Exception {

            String path = System.getProperty("user.dir")
                    + "/src/test/resources/TestData/UserData.xlsx";

            XLUtility xl = new XLUtility(path);

            int rowCount = xl.getRowCount("Users");

            String[] userNames = new String[rowCount];

            // username is in column index = 1
            for (int i = 1; i <= rowCount; i++) {
                userNames[i - 1] = xl.getCellData("Users", i, 1);
            }

            return userNames;
        }
    }



