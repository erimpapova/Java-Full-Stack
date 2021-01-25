
function fetchTeachersFromJSON(){
    let lastName = $('#searchInput').val().trim();

    let ajaxRequest = new XMLHttpRequest();
    ajaxRequest.open('GET',`/TeachersWebApp/TeacherSearchJSONController?searchInput=${lastName}`, true);
    ajaxRequest.send();

    ajaxRequest.onreadystatechange = function() {
        if (ajaxRequest.readyState == 4){
            if (ajaxRequest.status == 200) {
                handleResults(JSON.parse(ajaxRequest.responseText));
            } else {
                alert (`ERROR`);
            }
        }
    }
}

function handleResults(response){
	
    let teachersList = response;

    if (jQuery.isEmptyObject(response)){
        $(".teachers-list").html("Δεν βρέθηκαν καθηγητές")
    } else {
        let output = "<tr><th>ID</th><th>Όνομα</th><th>Επίθετο</th></tr>";

        for (let teacher of teachersList) {
            output += "<tr><td>"
            + teacher.id
            + "</td><td>"
            + teacher.fname
            + "</td><td>"
            + teacher.sname
            + "</td></tr>";
        }

        $(".teachers-list").html(output);
    }
}