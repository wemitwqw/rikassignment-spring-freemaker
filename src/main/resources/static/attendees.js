let company = document.getElementById("company");
let individual = document.getElementById("individual");

let companyName = document.getElementById("company-name");
let firstName = document.getElementById("individual-firstname");
let lastName = document.getElementById("individual-lastname");
let codeLabel = document.getElementById("codelabel");

company.addEventListener ("change", switcher);
individual.addEventListener ("change", switcher);

function switcher(){
    if (individual.checked) {
        companyName.classList.add('hidden');
        firstName.classList.remove('hidden');
        lastName.classList.remove('hidden');
        codeLabel.innerText = "Isikukood";
    }
    if (company.checked) {
        companyName.classList.remove('hidden');
        firstName.classList.add('hidden');
        lastName.classList.add('hidden');
        codeLabel.innerText = "Reg. nr";
    }
}

