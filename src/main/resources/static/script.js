"use strict";

(async () => {
    await loadEvents();

    document.getElementById("save").addEventListener("click", createEvent)
})()

async function loadEvents() {
    const response = await fetch("/api/events");
    const data = await response.json();

    const eventsUL = document.getElementById("events"); // querySelector / querySelectorAll

    eventsUL.innerHTML = "";

    data.forEach(event => {
        const eventLI = document.createElement("li"); // <li></li>

        eventLI.innerText = event.title; // <li>{event.title}</li>

        eventsUL.appendChild(eventLI); // Lägg vår LI i vår UL
    })
}

async function createEvent(){
    const title = document.getElementById("title").value;
    document.getElementById("title").value = "";

    const event = { title };

    const myHeaders = new Headers();
    myHeaders.append("Content-Type", "application/json");

    const raw = JSON.stringify(event);

    const requestOptions = {
        method: "POST",
        headers: myHeaders,
        body: raw,
        redirect: "follow"
    };

    await fetch("/api/events", requestOptions);

    await loadEvents();
}