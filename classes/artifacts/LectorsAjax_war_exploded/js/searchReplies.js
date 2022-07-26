window.onload = getReplies;




function getReplies() {
    axios.get("Controller?command=SearchReplies")
        .then(response => showReplies(response.data))
        .then(() => setTimeout(getReplies, 1000))
}


function showReplies (replies) {

   // console.log("replies: " +replies)
    //author ophalen
    let author = document.getElementById("authorSearch").value;
    //titel weergeven
   document.getElementById("titleSearch").innerText =  "Overview comments published by " + author;
   //tabel leegmaken
   document.getElementById("searchOverviewDiv").innerHTML = "";
    //error leegmaken
   let errorSearch = document.getElementById("errorSearch");
    errorSearch.textContent = "";

    let bodyReplies = document.getElementById("searchOverviewDiv");

    if (replies == null){
        let lectorText = document.createTextNode("No data to show, person " + author + " doesn't exists.");
        errorSearch.appendChild(lectorText)
    }else if (replies.length === 0) {
        let lectorText = document.createTextNode("No replies for " + author);
        errorSearch.appendChild(lectorText)
    }else{

        for (let i = replies.length; i !== 0; i--) {
            newsItemJson = replies[i - 1];
            let row = document.createElement("tr");
            let paragraph = row.childNodes[0];
            let paragraph1 = row.childNodes[1];

            let replyText = document.createTextNode(newsItemJson.text);
            let replyDate = document.createTextNode(newsItemJson.date.dayOfMonth + " " + newsItemJson.date.month + " " + newsItemJson.date.year);

            paragraph = document.createElement('td');
            paragraph1 = document.createElement('td');
            paragraph.appendChild(replyText);
            paragraph1.appendChild(replyDate);
            row.appendChild(paragraph);
            row.appendChild(paragraph1);
            bodyReplies.appendChild(row);
        }

    }

}

let searchbutton = document.getElementById('searchButton');
searchbutton.onclick = searchReply;
let addReplyRequest = new XMLHttpRequest();

function searchReply(){
    let author = document.getElementById("authorSearch").value;
    let information = "authorSearch=" + encodeURIComponent(author);
    addReplyRequest.open("POST", "Controller?command=Search", true);
    addReplyRequest.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
    addReplyRequest.send(information);

}