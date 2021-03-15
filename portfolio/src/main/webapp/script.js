// Copyright 2020 Google LLC
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     https://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

/**
 * Adds a random greeting to the page.
 */

async function getSecretMessage() {
    const response = await fetch('/secret-response');
    const response_json = await response.json();
    const random_message = '<h2>' + response_json[Math.floor(Math.random() * response_json.length)] + '</h2>';
    document.getElementById('secret-message-container').innerHTML = random_message;
}

async function sendMessage() {
    const params = new URLSearchParams({
            name: document.getElementById('name').value,
            recruiter: document.getElementById('recruiter').value,
            summary: document.getElementById('summary').value,
            message: document.getElementById('message').value
        });

    const response = await fetch('/form-handler?'+ params.toString(), {method:'POST'});
    const response_json = await response.json();
    localStorage.setItem('contact-form-response',response_json);

    document.getElementById('sentiment-before-send').style.display="none";
    document.getElementById('display-sentiment-div').style.display="block";
    document.getElementById('display-sentiment-div').style.paddingTop="20px";
    document.getElementById('display-sentiment-div').style.paddingBottom="20px";
}

function displaySentiment() {
    const sentiment_score = localStorage.getItem('contact-form-response');
    const display_sentiment = '<h2> The sentiment score of the message was: ' + sentiment_score + '</h2>';
    document.getElementById("sentiment-container").innerHTML = display_sentiment;
}