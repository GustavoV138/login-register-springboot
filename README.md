Um sistema de login de usuários bem simples.

Front end pelo ChatGPT utilizando HTML, CSS e JS;

Back end por mim, utilizando Java, Spring boot, Maven e PostgreSQL.

Ainda pretendo melhorar e diminuir a cachorrada que ficou. No mais, está até que funcionando bem.


Estrutura do projeto:

.idea
.mvn
src
---main
------java
------------com.vieira.login_register_fullstack_springboot
------------------controller
------------------------SiteHtmlController.java
------------------------UsuarioController.java
------------------model
------------------------UsuarioEntity.java
------------------repository
------------------------UsuarioRepository.java
------------------service
------------------------UsuarioService.java
------------------LoginRegisterFullStackSpringbootApplication.java
------resources
------------static
------------------htmls
------------------------login.html
------------------------register.html
------------------scripts
------------------------main.js
------------------styles
------------------------style.css
---test
