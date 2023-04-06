function setIdForDelete(id) {
    var element = document.getElementById("idForDelete");
    element.value = id;
}

function writeWhatIAmTyping() {
    var input = document.getElementById("whatIAmTyping");
    var text = document.getElementById("typing");
    var inputStr = input.value;
    text.innerHTML = inputStr;
}

function changeColor() {
    var btnSearch = document.getElementById("btnSearch");
    btnSearch.style = "background-color:red";
}

function showHide() {
    var btnSearch = document.getElementById("btnSearch");
    if (btnSearch.visible) {
        btnSearch.style = "display:none";
        btnSearch.visible = false;
    } else {
        btnSearch.style = "display:yes";
        btnSearch.visible = true;
    }
}