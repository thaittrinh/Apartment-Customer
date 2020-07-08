let id = document.getElementById('id-news').textContent;

(function () {
    $.ajax({
        type: 'GET',
        url: URL + `api/notification/${id}`,
        dataType: 'json',
        success: function (result) {
            document.getElementById('notification').innerHTML = result.content;
        },
        error: function (error) {
          
        }
    })
})()