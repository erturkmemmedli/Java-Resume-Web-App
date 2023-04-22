<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>

    <script>
        function printUsers(arr){
            const container = document.getElementById("container");
            container.innerHTML = '';

            for (let i = 0; arr.length; i++) {
                const obj = arr[i];
                const deleteBtn = '<button onclick = "deleteUser(' + obj.id + ')">DELETE</button>';
                const str = obj.id + " " + obj.name + " " + obj.surname + deleteBtn + "<br/>";
                container.innerHTML += str;
            }
        }

        function deleteUser(id){
            const xHttp = new XMLHttpRequest();

            xHttp.onreadystatechange = function() {
                if (this.readyState == 4 && this.status == 200) {
                    getUsers();
                }
            };

            xHttp.open("DELETE", "http://localhost:8085/resumerest/users/" + id, true);
            xHttp.send();
        }

        function getUsers() {
            const xHttp = new XMLHttpRequest();

            xHttp.onreadystatechange = function() {
                if (this.readyState == 4 && this.status == 200) {
                    const response = JSON.parse(this.responseText);
                    const list = response.obj;
                    printUsers(list);
                }
            };

            xHttp.open("GET", "http://localhost:8085/resumerest/users", true);
            xHttp.send();
        }

        function addUser() {
            const xHttp = new XMLHttpRequest();

            xHttp.onreadystatechange=function() {
                if (this.readyState == 4 && this.status == 200) {
                    getUsers();
                }
            };

            const name = document.getElementById("name").value;
            const surname = document.getElementById("surname").value;
            const password = document.getElementById("password").value;
            const user = {name: name, surname: surname, password: password};

            xHttp.open("POST", "http://localhost:8085/resumerest/users", true);
            xHttp.setRequestHeader("Content-Type", "application/json");
            xHttp.send(JSON.stringify(user));
        }
    </script>

</head>
<body onload = "getUsers()">
    <div>
<%--        <button onclick="deleteUser(32)" value="DELETE"/>--%>
        <input type = "text" id = "name"/>
        <input type = "text" id = "surname"/>
        <input type = "password" id = "password"/>
        <button onclick = "addUser()">ADD</button>
    </div>
    <div id = "container"></div>
</body>
</html>