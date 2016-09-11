# Dictionary-JAVA

###Its a netbeans project

Dictionary application shows the meaning of entered word in text field.
While the user is typing the word , related words will be displayed in the JList so that user can select appropriate word from that list

![ezgif com-video-to-gif](https://cloud.githubusercontent.com/assets/21156001/18415176/bb0a834c-7805-11e6-8818-242097822f57.gif)

The words of the dictionary are been taken from <a href="https://github.com/dwyl/english-words/blob/master/words.txt">here</a>.
These words are being inserted into trie data structure. Using trie data structure, suggestions are being controlled.
User can then select any of the words displayed in the list to view the meaning of the word.
The respective meanings of the words are being found out by  this <a href="http://developer.pearson.com/apis/dictionaries">API CALL</a>
The respnse of API is in JSON , I added org.json external library to the project and used the its classes to parse JSON response.

![20160911_095757](https://cloud.githubusercontent.com/assets/21156001/18415185/5594ab90-7806-11e6-9f23-9e36af36ebc3.gif)




