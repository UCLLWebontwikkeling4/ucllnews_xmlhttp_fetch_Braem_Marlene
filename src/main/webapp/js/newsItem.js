window.onload = getNewsItem;
let refreshNeeded = false;

let getRandomLectorRequest = new XMLHttpRequest();
// 0
// The request is not initialized.
// After you have created the XMLHttpRequest object, but before you have called the open() method.

function getNewsItem () {
	getRandomLectorRequest.open("GET", "Controller?command=Random", true);
	// 1
	// The request has been set up.
	// After you have called the open() method, but before you have called send().
	getRandomLectorRequest.onreadystatechange = showNewsItems;
	// mag NIET showRandomLector() zijn
	// want dat wordt het maar 1 keer uitgevoerd
	// en het moet telkens wanneer de readystate van het xhr veranderd worden uitgevoerd
	getRandomLectorRequest.send();
	// 2
	// The request has been sent.
	// After you have called send().
	//axios.get("Controller?command=Random")
	//	.then(response => showNewsItems(response.data))
	//	.then(() => setTimeout(getNewsItem, 10000))
}

// 3
// The request is in process.
// After the browser has established a communication with the server, but before the server has completed the response.

// 4
// The request is completed.
// After the request has been completed, and the response data has been completely received from the server.

// callback function
function showNewsItems () {
	let newsItems = JSON.parse(getRandomLectorRequest.responseText);

	console.log(newsItems)

			let newsItemDiv = document.getElementById("newsItemDiv");
			let paraph = newsItemDiv.childNodes[0];
			let newsItem = null;


	for (let i = newsItems.length; i !== 0; i--) {//komt door deze for loop
		newsItem = newsItems[i - 1];

		//newsitem
		if(document.body.innerHTML.search(newsItem.title) === -1 || refreshNeeded === true) {
			if(refreshNeeded === true){
				document.getElementById("newsItemDiv").innerHTML = "";
			}
			refreshNeeded = false;

				paraph = document.createElement("div");
				paraph.classList.add("newsitem");

				let titleElement = document.createElement("h2");
				let title = document.createTextNode(newsItem.title);
				titleElement.classList.add("title_newsitem");
				titleElement.appendChild(title);

				let textElement = document.createElement("p");
				let text = document.createTextNode(newsItem.text);
				textElement.classList.add("text_newsitem");
				textElement.appendChild(text);

				let authorDateElement = document.createElement("div");
				let authorElement = document.createElement("div");
				let author = document.createTextNode(newsItem.author);
				authorElement.appendChild(author);
				authorDateElement.appendChild(authorElement);
				authorDateElement.classList.add("author_date_newsitem");

				let dateElement = document.createElement("div");
				let date = document.createTextNode(newsItem.date.dayOfMonth + " " + newsItem.date.month + " " + newsItem.date.year);
				dateElement.appendChild(date);
				authorDateElement.appendChild(dateElement);

				//newsitem
				paraph.appendChild(titleElement);
				paraph.appendChild(textElement);
				paraph.appendChild(authorDateElement);

				newsItemDiv.appendChild(paraph);


				//voor elk nieuwsitem de replies
				let replies = newsItem.replies;
				let teller = 0;
				console.log("replies " +replies);
				for (let i = replies.length; i !== 0 && teller <5; i--) {//komt door deze for loop

					let reply = replies[i - 1];

					let replyElement = document.createElement("div");
					replyElement.classList.add("reply");

					let textReplyElement = document.createElement("p");
					let textReply = document.createTextNode(reply.text);
					textReplyElement.classList.add("text_newsitem");
					textReplyElement.appendChild(textReply);

					let authorReplyElement = document.createElement("div");
					let authorElement = document.createElement("div");
					let authorReply = document.createTextNode(reply.author);
					authorReplyElement.classList.add("author_date_newsitem");
					authorElement.appendChild(authorReply);
					authorReplyElement.appendChild(authorElement);

					let dateElement = document.createElement("div");
					let dateReply = document.createTextNode(reply.date.dayOfMonth + " " + reply.date.month + " " + reply.date.year);
					dateElement.appendChild(dateReply);
					authorReplyElement.appendChild(dateElement);

					replyElement.appendChild(textReplyElement);
					replyElement.appendChild(authorReplyElement);

					paraph.appendChild(replyElement);

					teller++;

				}

				// voor elk newsitem add reply
				let classnaam = "form" + i;
				//console.log(classnaam);
				let addReply = document.createElement("form");
				addReply.id = classnaam;


				let labelText = document.createElement("label");
				labelText.innerText = "Text";
				labelText.id = "idReply";

				let inputTextReply = document.createElement("input");
				inputTextReply.type = "text";
				inputTextReply.classList.add("form-control");
				let textReply = "textReply" + i;
				inputTextReply.id = textReply;

				let labelAuthor = document.createElement("label");
				labelAuthor.innerText = "Author";
				labelAuthor.id = "idReply";

				let inputAuthorReply = document.createElement("input");
				inputAuthorReply.type = "text";
				inputAuthorReply.classList.add("form-control");
				let authorReply = "authorReply" + i;
				inputAuthorReply.id = authorReply ;


				let buttonReply = document.createElement("input");
				buttonReply.type = "submit";
				buttonReply.type = "button";
				buttonReply.classList.add("btn", "btn-danger", "addNewsReplyButton");
				buttonReply.value = "Reply";
				buttonReply.onclick = () => addReplyComment(classnaam, authorReply, textReply, title.textContent, text.textContent);


				addReply.appendChild(labelText);
				addReply.appendChild(inputTextReply);
				addReply.appendChild(labelAuthor);
				addReply.appendChild(inputAuthorReply);
				addReply.appendChild(buttonReply);
				paraph.appendChild(addReply);

				}
	}
			setTimeout(getNewsItem, 1000);
		}


let addNewsItemButton = document.getElementById('addNewsItemButton');
addNewsItemButton.onclick = addNews;

let addNewsRequest = new XMLHttpRequest();

function addNews() {

	let title = document.getElementById("title_input").value;
	let text = document.getElementById("text_input").value;
	let author = document.getElementById("author_input").value;
	let information = "title_input=" + encodeURIComponent(title) + "&text_input=" + encodeURIComponent(text) + "&author_input=" + encodeURIComponent(author);
	console.log(information);
	addNewsRequest.open("POST", "Controller?command=Add", true);

	addNewsRequest.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
	addNewsRequest.send(information);

}

function addReplyComment(classnaam, authorid, texid, tittle, text) {
	console.log("in add reply");
	let textReply = document.getElementById(texid).value;
	let authorReply = document.getElementById(authorid).value;
	let info = "newItemId="+ encodeURIComponent(classnaam)+"&text=" + encodeURIComponent(textReply) + "&author=" + encodeURIComponent(authorReply)
		+ "&titleNewsItem=" + encodeURIComponent(tittle) + "&textNewsItem=" + encodeURIComponent(text);
	console.log(info);
	addNewsRequest.open("POST", "Controller?command=AddReply", true);
	addNewsRequest.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
	addNewsRequest.send(info);
	refreshNeeded = true;
	//location.reload();

}

