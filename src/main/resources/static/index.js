let contactos = [];

let test = [];
for (let i = 0; i < 20; i++) {
    test.push({
        id: i,
        todo: `Este es el contacto#${i}`,
    });
}

const addContacto= (contacto) => {
    // Save task in memory
    contactos.push(contacto);
    
};


const getContactos = async () => {
    // Call server
    let request = await fetch("/contactos");
    if (request.status == 200) {
        let data = await request.json();
        addContacto(data);
    }
};

const postContacto = async (correo) => {
    // Call server
    let request = await fetch("/contactos", {
        method: "POST",
        body: JSON.stringify({
            id: 0,
            correo: correo,
        }),
        credentials: "same-origin",
        headers: {
            "Content-Type": "application/json", // Indico que mis datos van a estar en JSON
        },
        dataType: "json",
        
    });
    

    if (request.status == 200) {
        let data = await request.json();
        addContacto(data);
        console.log(data);
        
    }
};

const start = () => {
    // For testing purposes
    getContactos();
    
    
};

const parseContacto = () => {
    const value = $("#correo").val();
    
    if (value.trim() == "") {
        return;
    }

    // Post new task
    postContacto(value);
    
};

$("#add").on("click", () => {
    // When the button #add is clicked
    // get the task and call the server
    parseContacto();
});

$(document).ready(() => {
    // When the document loads,
    // get all the tasks
    start();
});