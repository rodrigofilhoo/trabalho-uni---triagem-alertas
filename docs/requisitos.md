# Requisitos - Motor de Triagem de Alertas

## 1. Definição do Problema
**Contexto:** Setor de monitoramento de rede (NOC) de telecomunicações.
**Problema Atual:** Muitos alertas brutos e triagem manual, gerando lentidão pra resolver quedas pesadas.
**Solução Proposta:** Back-end em Java que classifica os alertas automaticamente (Crítico, Aviso, Info) usando regras de negócio.

## 2. Atores Envolvidos
* **Sistema Gerador:** Roteadores ou softwares de monitoramento que disparam o alerta.
* **Técnico de Redes:** O cara que vai atender a fila já filtrada e priorizada.

## 3. Requisitos (User Stories)
* **US01 - Recepção:** Como Sistema Gerador, quero enviar o alerta bruto pra registrar na fila com um ID único.
* **US02 - Regra Crítica:** Como Motor de Triagem, quero identificar termos como "fibra rompida" e classificar como "CRÍTICO" pro técnico agir na hora.
* **US03 - Regra de Aviso:** Como Motor de Triagem, quero identificar "latência alta" e classificar como "AVISO" pra monitoramento contínuo.
* **US04 - Regra Padrão:** Como Motor de Triagem, quero manter o restante dos alertas não mapeados como "INFO" apenas para histórico.