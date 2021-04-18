# java-blockchain-aws

 `mvn clean install`

 `spring-boot:run`

```
BlockChain{
  chain=[
    Block{
      index=0,
      "previusHash"="0",
      "data"={
        "Header":[
          "Genesis Block"
        ]
      },
      "hash"="779ef46f374f0b167a00a4d20f7cb64f86c002ae012b28f29af8b567da656c15",
      "timestamp=2021-04-18T11:57:54.479309700"
    },
    Block{
      index=1,
      "previusHash"="779ef46f374f0b167a00a4d20f7cb64f86c002ae012b28f29af8b567da656c15",
      "data"={
        "Order Amount":100.32
      },
      "hash"="54618b4c68617d636b53f9953750343d2ca415fd24c89882a93e19341ab2c6ea",
      "timestamp=2021-04-18T11:57:54.494936300"
    },
    Block{
      index=2,
      "previusHash"="54618b4c68617d636b53f9953750343d2ca415fd24c89882a93e19341ab2c6ea",
      "data"={
        "Order Amount":23.1
      },
      "hash"="013249a07fc3f7312fff76ca40a7fb0266e5719bae2528b7debe037261482cf7",
      "timestamp=2021-04-18T11:57:54.494936300"
    }
  ]
}

```
