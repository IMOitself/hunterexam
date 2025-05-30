![hakdog](images/image.png)

## Scroll Down

* **`_Phase1.java`**: (Ashton)
* **`_Phase2.java`**: (Tachi)
* **`_Phase3.java`**: (JR)
* **`_Phase4.java`**: (sir Rey)
* **`_PhaseFinal.java`**: (Meynard)

<details>
  <summary>Files for connecting everything:</summary>
  
* **`_Intro.java`**
* **`_PlayerScreen.java`** 
* **`Main.java`**
* **`UI.java`**
* **`Player.java`** 

</details>

---

### Our Gdocs link

**https://docs.google.com/document/d/1ucKV3zvFgoE3a4URU_5xpBQgntx16v6M493VRHTVhvc/edit?usp=sharing**

## 

<div align="center">

## ⬇️ Download
</div>

💻 WINDOWS

  * Download Git and run it
    [download link](https://github.com/git-for-windows/git/releases/download/v2.49.0.windows.1/Git-2.49.0-64-bit.exe)
  * Download OpenJDK and run it
    [download link](https://download.oracle.com/java/24/latest/jdk-24_windows-x64_bin.exe)
  * On your coding software e.g VS Code or other
  * <img src="images/instruction1.png" alt="hakdog" width="400"/>
  * <img src="images/instruction2.png" alt="hakdog" width="400"/>
* Enter this code in the Terminal
    ```bash
    git clone https://github.com/IMOitself/hunterexam.git
    cd hunterexam/
    ```
    
<details>
  <summary>📱 ANDROID</summary>
  
* Download Termux
    [download link](https://f-droid.org/repo/com.termux_1021.apk)
* Enter this code in Termux
    ```bash
    pkg update && pkg upgrade -y
    pkg install git openjdk-17 -y
    git --version
    java -version
    javac -version
    termux-setup-storage
    cd ~/storage/downloads
    git clone https://github.com/IMOitself/hunterexam.git
    cd hunterexam/
    ```
</details>

<div align="center">
<br/>
  
## ▶️ How to Run
</div>

💻 WINDOWS
  
* 
   ```bash
   javac -d classes *.java
   java -cp "classes;mysql-connector-j-9.3.0.jar" Main
   ```
   
</details>
<details>
  <summary>📱 ANDROID</summary>
  
* 
   ```bash
   javac -d classes *.java
   java -cp classes:mysql-connector-j-9.3.0.jar Main
   ```
   
</details>

<div align="center">
<br/>
  
## 🔃 How to Update
</div>

* Enter this code
    ```bash
    git pull
    ```
