
function confirmDelete(idClient) {
    if (confirm("Určitě chceš odstranit tohoto pojištěnce?")) {
        document.getElementById('delete-client-form-' + idClient).submit();
    }
}

function confirmInsuranceDelete(idInsurance) {
    if (confirm("Určitě chceš odstranit toto pojištění?")) {
        document.getElementById('delete-insurance-form-' + idInsurance).submit();
    }
}
