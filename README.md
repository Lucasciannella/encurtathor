# Encurtathor :rocket: 

Fala galera! Apresento a vocês o  encurtador de url Encurtathor.

- O conceito por trás desta aplicação é  o de encurtar as urls. Um recurso muito usado na web mundo a fora, diversos sites e empresas tem uma Api como essa. Por exemplo:
  - *Empresas que utilizam esse conceito*: Amazon, Linkedin,etc. 
  - *Empresas que oferecem esse serviço*: Bitly, etc.

## Sobre  usabilidade :hammer_and_wrench:

- Com a evolução dos serviços web e suas tecnologias as url começaram a aumentar demasiadamente.
- O encurtador tem como  um de seus principais objetivos diminuir o tamanho das urls, tornando um link mais atrativo para o Usuário final, e podendo ser mais seguro em alguns casos.  

## Funcionamento :computer:

- Se você ficou interessado e fazer um clone do projeto  deixo aqui as instruções;

  - Você vai precisar de um servidor Mysql rodando em sua maquina, poderá alterar as configurações no application.properties do Spring para que fique com os mesmos registros do seu usuário no servidor. ( caso queria usar um outro banco de dados  é só ajustar a configuração no mesmo arquivo " aplication.properties");

    

  - Temos dois métodos nesse projeto, um para criar a Url encurtada e outro para redirecionar. Como ainda não temos o Frontend do projeto para usar dos métodos você precisa do postman ou algum programa similar para passar os parâmetros no corpo da requisição:![image-20220623151125708](C:\Users\Lucas\Desktop\LTDA\encurtathor\midia\image-20220623151125708.png)

  - 

    

  - E para acessar sua url encurtada você ira usar o domínio local com o hash que você criou:![image-20220623152415465](C:\Users\Lucas\Desktop\LTDA\encurtathor\midia\image-20220623152415465.png)
  
    
    
    Você pode testar no postman e depois passar o caminho no seu navegador, verá que o método ira te redirecionar a url original. 



## Futuro 

É da minha vontade evoluir esse projeto e aqui vão  as evoluções previstas:

- *Front-end da aplicação*: fazer toda a construção do front end desta aplicação 

- *Usuários* : vai ser  possível criar um usuário autenticado que possa criar nº números de links encurtados podendo gerenciar a quantidade de clicks em cada link, com isso um dashbord para gerenciar esses clicks.

  

## Mídias 

Se você gostou do projeto, ou se tiver alguma sugestão entra em contato comigo!

[ :telescope: clicando aqui! ](https://beacons.ai/ciannella) 





