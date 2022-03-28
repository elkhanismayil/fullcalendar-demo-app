document.addEventListener('DOMContentLoaded', function () {
    var calendarEl = document.getElementById('calendar');

    var calendar = new FullCalendar.Calendar(calendarEl, {
        locale: 'az',
        headerToolbar: {
            left: 'prev,next today',
            center: 'title',
            right: 'dayGridMonth,timeGridWeek,timeGridDay,listWeek'
        },
        // height: 'auto',
        slotMinTime: '08:00',
        slotMaxTime: '16:00',
        height: '100%',
        themeSystem: 'bootstrap5',
        timeFormat: 'H(:mm)',
        expandRows: true,
        weekends: false,
        allDay: false,
        timeZone: 'UTC',
        eventTimeFormat: { // like '14:30:00'
            hour: '2-digit',
            minute: '2-digit',
            hour12: false
        },
        dayHeaderFormat: {
            weekday: 'long'
        },
        views: {},
        // titleFormat: {
        //     year: 'numeric', month: 'long', day: 'numeric'
        // },
        // editable: true,
        selectable: true,
        selectHelper: true,
        titleFormat: 'MMMM, YYYY',
        select: function (start, end, allDays ) {
            $('#bookingModal').modal('toggle');
            $('#saveBtn').click(function () {
                let title = $('#title').val();
                let start_date = moment(start).format('YYYY-MM-DDTHH:mm:ss');
                let end_date = moment(end).format('YYYY-MM-DDTHH:mm:ss');

                $.ajax({
                    url: 'http://localhost:8080/api/save',
                    type: 'POST',
                    contentType: 'application/json',
                    data: JSON.stringify({ title, start_date, end_date }),
                    success: function (response) {
                        console.log(response)
                    },
                    error: function (error) {

                    }
                });
            });
        },
        // navLinks: true, // can click day/week names to navigate views
        // dayMaxEvents: true, // allow "more" link when too many events
        events: {
            url: 'http://localhost:8080/api/all',
            failure: function () {
                // document.getElementById('script-warning').style.display = 'block'
            },
            color: 'green',
            textColor: 'white'
        },
        loading: function (bool) {
            // document.getElementById('loading').style.display =
            //     bool ? 'block' : 'none';
        },

    });
    calendar.render();
});

// function ajaxReq() {
//     if (window.XMLHttpRequest) {
//         return new XMLHttpRequest();
//     } else if (window.ActiveXObject) {
//         return new ActiveXObject('Microsoft.XMLHTTP');
//     } else {
//         alert('Browser does not support XMLHTTP.');
//         return false;
//     }
// }