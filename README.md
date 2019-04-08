# News
News is news app provide many types of news that interest you, In an easy and fast way.

# Screenshoots
![device-2019-04-08-211937](https://user-images.githubusercontent.com/22882810/55747366-c58ae180-5a44-11e9-9d69-613d33742705.png)

![device-2019-04-08-210646](https://user-images.githubusercontent.com/22882810/55747433-e6533700-5a44-11e9-8f27-3562d448be44.png)

![device-2019-04-08-210828](https://user-images.githubusercontent.com/22882810/55747443-ece1ae80-5a44-11e9-92ed-ea4dffdcccc1.png)

![device-2019-04-08-210951](https://user-images.githubusercontent.com/22882810/55747449-f3702600-5a44-11e9-8176-b0ceefb65c03.png)

# Project Design Pattern

This project based on MVP (Model-View-Presenter) design pattern. 
The general advantages that one gets from implementing MVP are: 
Clear separation of responsibilities between components. This separation allows for an easier understanding and maintenance of the code base.

# App Work Flow

- Splash Activity: in this screen the app load most recently news for user by calling the NY Times Api using Retrofit app client and RX Java/Android with parameters API key and period.
after load complete the app navigate to Main Activty.

- Main Activity: this is the core screen and it have the news list so the user can select any item to show the details screen or you can select period of news from option menu on top right of main activity screen.
The user can refresh the new at any time form the refresh button on actionbar.

- Details Activity: show the details of news item.

# Build Release
You can build the apk by command line as below:

- put the key store file under app directory. 

- navigate the build.gradle for app and edit signing config( file name, password for key store, keyalias and keypassword) under android block as
below:
signingConfigs {
        release {
            storeFile file("testkeystore.jks")
            storePassword "asd123"
            keyAlias "test"
            keyPassword "asd123"
        }
    }
    
- open terminal and type "gradlew assembleRelease".
- the apk will stored in release folder under app directory.



# Code Analysis:
A static analysis tool called "lint" can help you find dangerous and non-portable constructs in your code before your compiler turns them into run-time bugs.

- you can find the configrations of analysis tool in build.gradle under app directory under android block as below: 
lintOptions {
        lintConfig file([path of lint construction file])
        htmlOutput file([path of output file])
        warningsAsErrors 
        xmlReport 
    }
    
- Configure the lint file:
You can specify your lint checking preferences in the lint.xml file. If you are creating this file manually, place it in the root directory of your Android project.
The lint.xml file consists of an enclosing <lint> parent tag that contains one or more children <issue> elements. Lint defines a unique id attribute value for each <issue>.
You can change an issue's severity level or disable lint checking for the issue by setting the severity attribute in the <issue> tag.
- Output file
When the lint tool completes its checks, it provides paths to the XML and HTML versions of the lint report. You can then navigate to the HTML report and open it in your browser, you will
this file under the root directory.




