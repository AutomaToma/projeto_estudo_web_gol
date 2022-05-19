#language:pt
#encoding:UTF-8

Funcionalidade: Emissao G3

  @CT-1
  Cenario: Realizar emissao G3 Nacional - Tarifa Light - Somente ida com sucesso
    Dado que eu esteja na home da Gol
    E realize uma busca G3 Nacional "Só ida ou Volta" para "GRU" e "GIG" no dia "31/05/2022"
    E selecione um voo com a tarifa "Light"
    E ir para o login "sem logar"
    E inserir os dados do passageiro com:
      | nome   | sobrenome | dataNascimento | genero    | documento | numeroDocumento | cpf         | email           | celular     |
      | Hudson | Edson     | 01/01/1991     | Masculino | RG        | 131673788       | 00000000000 | teste@teste.com | 11998989898 |
    Quando selecionar o assento
    E na personalizacao "avançar para resumo"
    Entao no resumo deve ser validado os dados e valores do voo selecionado

