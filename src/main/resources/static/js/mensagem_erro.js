// PARA mensagem de erro: ainda não executada no arquivo...

if(input.validity.valid) {
       input.parentElement.classList.remove('input-container--invalido')
       input.parentElement.querySelector('.input-mensagem-erro').innerHTML = ''
} else {
       input.parentElement.classList.add('input-container--invalido')
       input.parentElement.querySelector('.input-mensagem-erro').innerHTML = mostraMensagemDeErro(tipoDeInput, input)
}


const tiposDeErro = [
   'valueMissing',
   'typeMismatch',
   'patternMismatch',
   'customError'
]

const mensagensDeErro = {
   nome: {
       valueMissing: 'O campo de nome não pode estar vazio.'
   },
   email: {
       valueMissing: 'O campo de email não pode estar vazio.',
       typeMismatch: 'O email digitado não é válido.'
   },
   //senha: {
       //valueMissing: 'O campo de senha não pode estar vazio.',
       //patternMismatch: 'A senha deve conter entre 6 a 12 caracteres, deve conter pelo menos uma letra maiúscula, um número e não deve conter símbolos.'
   //},
   dataNascimento: {
       valueMissing: 'O campo de data de nascimento não pode estar vazio.',
       customError: 'Você deve ser maior que 18 anos para se cadastrar.'
   },
   cpf: {
       valueMissing: 'O campo de CPF não pode estar vazio.',
       customError: 'O CPF digitado não é válido.' 
   },
   telefone : {
       valueMissing: 'O campo de telefone não pode estar vazio.',
       customError: 'O telefone digitado não é válido.'
   },
   celular : {
       valueMissing: 'O campo de celular não pode estar vazio.',
       customError: 'O celular digitado não é válido.'
   },
   cep: {
       valueMissing: 'O campo de CEP não pode estar vazio.',
       patternMismatch: 'O CEP digitado não é válido.',
       customError: 'Não foi possível buscar o CEP.'
   },
   logradouro: {
       valueMissing: 'O campo de logradouro não pode estar vazio.'
   },
   cidade: {
       valueMissing: 'O campo de cidade não pode estar vazio.'
   },
   estado: {
       valueMissing: 'O campo de estado não pode estar vazio.'
   }
}

const validadores = {
   dataNascimento:input => validaDataNascimento(input),
   cpf:input => validaCPF(input),
   cep:input => recuperarCEP(input) 
}

function mostraMensagemDeErro(tipoDeInput, input) {
   let mensagem = '';
   tiposDeErro.forEach(erro => {
       if(input.validity[erro]) {
           mensagem = mensagensDeErro[tipoDeInput][erro]
       }
   })
   
   return mensagem
}

