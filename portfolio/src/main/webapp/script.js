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
    const response = await fetch('/secret-response')
    const response_json = await response.json();
    const random_message = '<h2>' + response_json[Math.floor(Math.random() * response_json.length)] + '</h2>';
    document.getElementById('secret-message-container').innerHTML = random_message;
}