//Para validar os campos editados pelo úsuario 
var validos = () => {
   if (document.getElementById("nome").value == "") return false;
   if (document.getElementById("email").value == "") return false;
   //if (document.getElementById("senha").value == "") return false;
   if (document.getElementById("nascimento").value == "") return false;
   if (document.getElementById("telefone").value == "") return false;
   if (document.getElementById("celular").value == "") return false;
   if (document.getElementById("cep").value == "") return false;
   if (document.getElementById("numero").value == "") return false;
   if (document.getElementById("infor_adicional").value == "") return false;

}
//Validar funções de validação
function validarFormulario() {
   return validarCpf() && menorDeIdade(document.getElementById("nascimento").value) && validarEmail() && validarTel();

}
//Para validar o CPF
var validarCpf = () => {
   var valiCpf = document.querySelector('#cpf').value;
   var regexCpf = /[0-9]{3}[.]?[0-9]{3}[.]?[0-9]{3}[.]?[\/-]?[0-9]{2}/;

   if (!regexCpf.test(valiCpf)) {
      alert('CPF está inválido');
      document.querySelector('#cpf').focus();
      return false;
   }
   return true;
}
//Validação da maioridade (possui mais de 18 idade) e transformar data de nascimento em uma string

let menorDeIdade = (data) => {

   dataAtual = new Date();

   data = new Date(data);
   const dataMais18 = new Date(data.getUTCFullYear() + 18, data.getUTCMonth(), data.getUTCDate())

   if (dataMais18.getTime() <= dataAtual.getTime()) {
      return true;
   } else {
         alert('Você não tem idade para se cadastrar')
         return false;

   }

}
let dataS = () => {
   let nascimento = document.getElementById("nascimento").value;
   let data = new Date(nascimento);
   let mes = data.getUTCMonth() + 1;
   let ano = data.getUTCFullYear();
   let dia = data.getUTCDate();
   let nascimentoString = dia + '/' + mes + '/' + ano;

   return nascimentoString;

}



//Validação do email
var validarEmail = () => {
   var valiEmail = document.querySelector('#email').value;
   var regexEmail = /[a-z0-9_-]{1,}[@][a-z0-9.]{1,}[a-z]{2,3}/;

   if (!regexEmail.test(valiEmail)) {
      alert('E-mail está inválido');
      document.querySelector('#email').focus();
      return false;
   }
   return true;
}
//Validação do telefone
var validarTel = () => {
   var valiTel = document.querySelector('#telefone').value;
   var regexTel = /[(]?[0]?[0-9]{2}[)]?[.]?[0-9]{4,5}[-]?[0-9]{4}/;

   if (!regexTel.test(valiTel)) {
      alert('Telefone está inválido');
      document.querySelector('#telefone').focus();
      return false;
   }
   return true;
}

//Preenchendo dados para o CEP
const cep = document.querySelector("#cep");

const showData = (result) => {
   for (const campo in result) {
      if (document.querySelector("#" + campo)) {
         document.querySelector("#" + campo).value = result[campo]
      }
   }
}

cep.addEventListener("blur", (e) => {
   let procurar = cep.value.replace("-", "")
   const options = {
      method: 'GET',
      mode: 'cors',
      cache: 'default'
   }


   fetch(`https://viacep.com.br/ws/${procurar}/json/`)
      .then(response => {
         response.json()
         .then(data => showData(data))
      })
      .catch(e => console.log('Deu Erro: ' + e, message))

})
// PARA exibir os dados na tela com json
let verify_form = (event) => {
   event.preventDefault();
   if (validos() == false) {
      alert("Dados incompletos");
      return;
   }
   if (!validarFormulario()) {
      return;
   }

   let obj_form = {
      name: document.getElementById("nome").value,
      email: document.getElementById("email").value,
      //senha: document.getElementById("senha").value,
      nascimento: dataS(),
      cpf: document.getElementById("cpf").value,
      telefone: document.getElementById("telefone").value,
      celular: document.getElementById("celular").value,
      cep: document.getElementById("cep").value,
      numero: document.getElementById("numero").value,
      complemento: document.getElementById("infor_adicional").value,
      rua: document.getElementById("logradouro").value,
      bairro: document.getElementById("bairro").value,
      cidade: document.getElementById("localidade").value,
      estado: document.getElementById("uf").value

   }

   console.log(obj_form);

   var json = JSON.stringify(obj_form);
   console.log(json);

   document.write("<h1>Confira os dados digitados no formado Json</h1>");
   document.write(json);

   return json;
}