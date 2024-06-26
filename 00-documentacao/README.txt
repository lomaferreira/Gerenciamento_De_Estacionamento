# Gerenciador de estacionamento

Este é um sistema para gerenciamento de estacionamento completo, desde as vagas ate os veículos. Também com possibilidade de gerenciamento de clientes e pagamento, de acordo com o tipo de veículo e tempo de uso das vagas.

##Estrutura de Pacotes

 - Banco de dados - Possui todos os arquivos com as irformações que serão salvas do sistema, são eles: histórico,entrada e saida de veículos, pagamentos, vagas reservadas, clientes cadastrados e vagas cadastradas.
 
 - Controle de entradas e saidas -  Guarda a classe veículo que é estendida pelas outras classes Carro,Moto e Caminhao, juntamente com o gerenciamento de entradas desses veículos.

 - Gerenciamento de clientes - O pacote possui uma classe de controle de clientes, através dela que são realizadas ações,como cadastro de clientes, atualizações dos dados de cada cliente e ainda a consulta pelos clientes cadastrados.

 - Gerenciamento de pagamentos - Trabalha com toda a parte financeira do programa, desde a lógica de pagamento a tabela de preços.

 - Gerenciamento de vagas - Tem todas as funções que envolve o cadastramento de vagas, atualizações de status e verificar a disponibilidade de vaga.

 - Reserva de vagas - Um pacote a parte para trabalhar com as funções envolvendo a reserva de vaga por clientes cadastrados, além de conter a função que auxilia no gerenciamento das vagas após o período de tempo reservado.

 - Relatórios e consultas - Guarda funções que pecorrem o banco de dados e resgatam as informações necessárias para gerar cada relatório do sistema.

 - Leitura e Escrita de aquivos - Armazena uma classe responsavel apenas pela escrita e leitura de todos os arquivos disponiveís no banco de dados.

 - Design de telas - Possui classes que auxíliam na criação da interface do programa.

## Veículos

Esse sistema é desenvolvido para comportar três tipos de veículos, dentre eles estão (Todos os veículos possuem as características horarioEntrada e idVaga):

 - Carro - Suas características são cor,marca e modelo.

 - Moto - Possui como características as cilindradas

 - Caminhão - Possui a carga máxima e o comprimento.

## Estacionamento 

Alocar vaga - Nessa aba é possível alocar um vaga - Obtém a utilização de uma vaga existente em específico, onde é necessário identificar o tipo do veículo, além de seus dados de características únicas de acordo com seu tipo, e o horário de entrada do veículo.

Reservar vaga - Onde, como acima, é necessário identificar o tipo de veículo, além de seus dados acordo com suas características únicas, e o horário de entrada do veículo, o tempo reservado e as informções do cliente cadastrado.

Cadastrar nova vaga - Criar uma nova vaga, onde é necessário sua localização, número, status e o tipo de veículo, além do seu id único para criar a vaga.

## Gerenciamento de Clientes

Cadastrar clientes - Realiza o cadastro de clientes, coletando seu dados pessoais,como nome,telefone,email e o veiculo que ele possui.

Atualizar clientes - Recebe as informações de clientes já pré-cadastrados e as novas informações, realizando assim a atualização dos dados.

## Realizar Pagamentos

 - Inicializa na página de pagamentos, aceita informações referentes ao pagamento, sendo elas o tipo de pagamento, o  valor entregue e o id da vaga que se deseja realizar o pagamento,por fim o veículo é liberado e é emitido um recibo de pagamento constando essas informações.

 ## Relatórios e Consultas

Relatório de ocupação - Nessa aba é possível consultar os veículos que estão atualmente no estacionamento, juntamente com aqueles que já sairam, permitindo um controle em tempo real dos veículos.

Histórico - Toda entrada e saida de veículos é registrada no hitórico do sistema, assim que uma nova vaga é alocada ou quando um veículo é retirado do estacionamento.

Relatório financeiro - Gera um relatório contendo as informações de pagamento, o valor pago e o id da vaga que pagou, além disso seus valores são somados e o total é mostrado no relatório.



