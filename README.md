# microtrack-sdk

versão: 1.0

Artigo publicado sobre o projeto: 

## Utilização

1. Pré-requisitos: Ter instalado na máquina o Java e Apache Maven;
2. Clonar o repositório;
3. Na classe CentralService, alterar a variável "uri" para o endpoint disponibilizado pelo [microtrack-service](https://github.com/pedrofaria18/microtrack-service), para que seja possível o envio dos dados à ele;
4. Realizar o build "clean install" do Maven, utilizando o plugin "Maven Helper" do Intellij, ou executando o comando "mvn clean install". Após, isso será gerado um arquivo .jar no seu repositório local do Maven, que poderá ser referenciado como uma dependência Maven em outros softwares da seguinte maneira:
```Java
<dependency>
  <groupId>org.microtrack</groupId>
  <artifactId>microtrack</artifactId>
  <version>1.0</version>
</dependency>
``` 

5. O SDK funciona da seguinte maneira: O desenvolvedor deve definir pontos (checkpoints) dentro de cada microsserviço que compõe sua arquitetura em que se deseja rastrear os dados que ali serão trafegados.
Para defini-los o desenvolvedor deve:
   * Criar uma única instância da classe "Manager". Ela é responsável por definir algumas constantes de configuração do SDK, como ’isTracingEnabled’ que indica se o registro de tracer está habilitado, ou não (possibilitando o desenvolvedor desabilitar o uso da solução a qualquer momento);
   * Criar uma única instância da classe "TraceService", que contém os métodos necessários para a criação de um checkpoins;
   * Criar os checkpoints desejados. Para isso, basta instanciar um objeto da classe “Trace”, passando as informações desejadas, e passá-lo como parâmetro do método “checkpoint” do TraceService.

```Java
Manager manager = new Manager(true);
TraceService traceService = new TraceService();

Trace trace = new Trace();
trace.setTraceId(username);
trace.setServiceName("microsservico_1");
trace.setCheckpointName("Login efetuado com sucesso");
trace.setError(Boolean.FALSE);
trace.setSuccessorBy(new ArrayList<>());

ResponseTrace response = traceService.checkpoint(manager, trace);
``` 

