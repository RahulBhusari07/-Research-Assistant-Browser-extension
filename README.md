### 📌 **Research Assistant Browser Extension**  
🚀 *A smart browser extension that helps researchers summarize articles, take notes, and enhance productivity using AI!*  

---

## 📖 **Overview**  
The **Research Assistant Browser Extension** enables users to efficiently summarize selected text on web pages, store notes locally, and retrieve them anytime. Powered by **Spring Boot** and **Google Gemini AI**, this tool streamlines the research process by providing instant AI-generated summaries.  

---

## 🔥 **Key Features**  
✅ **AI-powered Summarization** – Quickly summarize selected text using **Google Gemini API**  
✅ **Local Storage for Notes** – Save and retrieve notes across browsing sessions  
✅ **User-friendly UI** – Simple, intuitive design for seamless experience  
✅ **Real-time Backend Communication** – Spring Boot backend handles AI interactions efficiently  
✅ **Validation Check** – Ensures that users select text before summarization  

---

## 🛠 **Tech Stack**  
🔹 **Frontend:** HTML, CSS, JavaScript  
🔹 **Backend:** Java, Spring Boot, REST API  
🔹 **Database:** Local Storage (Browser)  
🔹 **AI Integration:** Google Gemini API  
🔹 **Browser Extension:** Chrome Extension Manifest v3  

---

## 📂 **Project Structure**  
```
📦 Research-Assistant-Browser-Extension
 ┣ 📂 backend
 ┃ ┣ 📜 ResearchAssistantApplication.java
 ┃ ┣ 📜 SummarizationController.java
 ┃ ┣ 📜 NotesService.java
 ┃ ┗ 📜 AIIntegrationService.java
 ┣ 📂 extension
 ┃ ┣ 📜 manifest.json
 ┃ ┣ 📜 popup.html
 ┃ ┣ 📜 popup.js
 ┃ ┣ 📜 styles.css
 ┃ ┗ 📜 background.js
 ┗ 📜 README.md
```  

---

## 📃 **Installation & Setup**  

### 💻 **1. Clone the Repository**  
```sh
git clone https://github.com/RahulBhusari07/-Research-Assistant-Browser-extension.git
cd Research-Assistant-Browser-Extension
```

### 🚀 **2. Running the Backend**  
Ensure you have **Java 8+** and **Spring Boot** installed.  
```sh
cd backend
mvn spring-boot:run
```

### 🌐 **3. Loading the Extension in Chrome**  
1. Open Chrome and navigate to `chrome://extensions/`  
2. Enable **Developer mode** (toggle switch in the top-right corner)  
3. Click **Load Unpacked** and select the `extension` folder  
4. The extension is now ready to use! 🎉  

---

## 📜 **Documentation**  
📄 **[Read the Full Documentation Here](https://docs.google.com/document/d/e/2PACX-1vQdnP9e8r3cBLxQZ6idKYSEij37IKUhHhsmMwjabbkyZSXfnry092azuFFjoVZm-pmRhyLD8OjhqH_C/pub)**  

---

## 🛠 **Contributing**  
We welcome contributions! To contribute:  
1. Fork the repository 🍴  
2. Create a new branch `feature-branch-name`  
3. Commit your changes ✍️  
4. Push the changes and create a **Pull Request** 🔄  

---

## 🌟 **Show Your Support**  
⭐ If you like this project, **give it a star** and share it! 🚀  
