async function loadStudents() {

    const table = document.getElementById("studentTable");
    const message = document.getElementById("message");
    const count = document.getElementById("studentCount");
    const status = document.getElementById("status");

    message.innerText = "Connecting to Student Microservice...";

    try {

        // Request goes through API Gateway
        const response = await fetch("/students");

        if (!response.ok) {
            throw new Error("Student service returned an error");
        }

        const students = await response.json();

        table.innerHTML = "";

        if (!Array.isArray(students) || students.length === 0) {

            table.innerHTML = `
                <tr>
                    <td colspan="4" style="text-align:center;">
                        No student records found.
                    </td>
                </tr>
            `;

            count.innerText = "0";

        } else {

            students.forEach(student => {

                const row = document.createElement("tr");

                row.innerHTML = `
                    <td class="student-id">
                        ${student.id ?? "-"}
                    </td>

                    <td>
                        <strong>
                            ${student.name ?? student.studentName ?? "-"}
                        </strong>
                    </td>

                    <td>
                        <span class="course">
                            ${student.course ?? student.program ?? "-"}
                        </span>
                    </td>

                    <td>
                        <span class="service-tag">
                            ✓ Via Gateway
                        </span>
                    </td>
                `;

                table.appendChild(row);
            });

            count.innerText = students.length;
        }

        status.innerText = "Online";

        message.innerText =
            "✓ Student data successfully received through API Gateway.";

    } catch (error) {

        console.error(error);

        table.innerHTML = `
            <tr>
                <td colspan="4" style="text-align:center; padding:30px;">
                    Unable to connect to Student Microservice.
                </td>
            </tr>
        `;

        count.innerText = "0";

        status.innerText = "Offline";

        message.innerText =
            "✕ Student Microservice is not available on port 8084.";
    }
}


function showStudents() {
    loadStudents();

    window.scrollTo({
        top: 500,
        behavior: "smooth"
    });
}


document.addEventListener("DOMContentLoaded", function () {
    loadStudents();
});