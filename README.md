# JavaRestApi
Simple Restful API using Java as programming language, Spring as framework, and Mysql as database.

# Database Configuration
<span>CREATE DATABASE javarestapi;<br/>
CREATE TABLE songs (<br/>
    id INT AUTO_INCREMENT PRIMARY KEY,<br/>
    title VARCHAR(50) NOT NULL,<br/>
    singer VARCHAR(50) NOT NULL<br/>
);

grant all on javarestapi.* to 'javarest'@'localhost';
</span><br/>

<br/>

# API Endpoint
<ul>
    <li> Create New Song<br/>
        POST: <a href="#">http://localhost:5555/song</a><br/>
        body:<br/>
        {<br/>
	    "Title":"Fight Song",<br/>
	    "Singer":"Rachel Platten"<br/>
        }<br/>
    </li>
    <li> Get All Songs<br/>
        GET: <a href="#">http://localhost:5555/songs</a><br/>
    </li>
    <li> Get Song by Id<br/>
        GET: <a href="#">http://localhost:5555/song/3</a><br/>
    </li>
    <li> Update A Song by Id<br/>
        PUT: <a href="#">http://localhost:5555/song/1</a><br/>
        body:<br/>
        {<br/>
	    "title": "Photograph",<br/>
  	    "singer": "Ed Sheeran"<br/>
        }</br>
    </li>
    <li> Delete A Song by Id<br/>
        GET: <a href="#">http://localhost:5555/song/3</a><br/>
    </li>
</ul>
