# Singleton pattern

- Pode ser considerado o mais simples para entendimento, mas não para implementação.
- Seu objetivo é garantir uma unica instancia de objeto na aplicação inteira, mesmo entre escopos e threads diferentes.
- Um exemplo é utilizar um singleton para guardar um unico estado por toda aplicação, como Logging, Fabrica de objetos (Factory) ou acesso a banco de dados.
  - Esse singleton geralmente é utilizado como unico ponto de acesso a algum outro recurso.
- Em java, utilizamos o método construtor como privado para não permitir criações e expomos um único método para obter a instancia.

## Tipos de Singleton

### Eager initialization

- Cria um unico componente o mais cedo possível, por se tratar de um campo estatico, a criação ocorre assim que é carregada na JVM
- Thread Safe

```java
package org.example;

public class SingletonEagerInitialization {

    private static final SingletonEagerInitialization singletonEagerInitialization = new SingletonEagerInitialization();

    private SingletonEagerInitialization() {
    }

    public static SingletonEagerInitialization getInstance() {
        return singletonEagerInitialization;
    }
}
```

### Static block initialization

- Utiliza o static block do java para criar a instancia
- No java, blocos estaticos são executados assim que carregados na JVM e apenas uma vez
- É igual ao Eager initialization, com a diferença que com o block estatico é possível colocar uma lógica complexa, como try/catch
- Thread Safe

```java
package org.example;

public class SingletonStaticBlock {

    private static SingletonStaticBlock instance;

    static {
        instance = new SingletonStaticBlock();
    }

    private SingletonStaticBlock() {
    }

    public static SingletonStaticBlock getInstance() {
        return instance;
    }
}
```

### Lazy initialization

- Inicia o componente quando é necessário, não carregando em memoria sem necessidade
- Util quando temos algum processo evolvendo sua criação, podendo ser postergado apenas quando necessário
- Não é thread safe, pode have problema de concorrência na criação do objeto (condição de corrida)

```java
package org.example;

public class SingletonLazy {

    private SingletonLazy() {
    }

    private static SingletonLazy singletonLazy;

    public static SingletonLazy getInstance() {
        if (singletonLazy == null) {
            singletonLazy = new SingletonLazy();
        }
        return singletonLazy;
    }
}

```

- Para garantir que o lazy seja thread safe e evitar dores de cabeça, faça uso da keywork syncronized no java. Ex:
- PS: A keywork synchronized em java é uma forma de garantir que apenas uma thread acesse o bloco por vez, as demais devem esperar o bloco finalizar.

```java
package org.example;

public class SingletonLazyThreadSafe {

    private static SingletonLazyThreadSafe instance;

    private SingletonLazyThreadSafe() {

    }

    private static SingletonLazyThreadSafe getInstance() {
        synchronized (SingletonLazyThreadSafe.class) {
            if (instance == null) {
                System.out.println("some processing thread safe");
                instance = new SingletonLazyThreadSafe();
            }
        }
        return instance;
    }
}
```

### Bill Pugh initialization

- É um método de criação da instancia de uma forma Lazy (apenas quando requerido) sem necessitar do synchronized keyworkd, usado em codigo legal principalmente
- Também pode ser usado de forma a evitar o overhead na sincronização das threads (bloqueante/synchronized).

```java
package org.example;

public class SingletonBillPugh {

    private SingletonBillPugh() {

    }

    private static class InnerStaticClass {
        private static final SingletonBillPugh instance = new SingletonBillPugh();
    }

    public static SingletonBillPugh getInstance() {
        return InnerStaticClass.instance;
    }
}
```