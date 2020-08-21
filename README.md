# Machines
Create machines that automatically generate items for you.

### Prerequisites
* Java 8+
* [Spigot 1.8.8](https://cdn.getbukkit.org/spigot/spigot-1.8.8-R0.1-SNAPSHOT-latest.jar)

### Default Configuration
```yml
machines:
  basic:
    price: 250000
    name: "&aBasic Machine &2(Tier I)"
    machine-id: 45
    drop-id: 336
    drop-amount: 64
    description:
      - ""
      - "&2This machine is good."
      - "§aTier I"
      - ""
```

### Examples
Returning a player's machine.
```java
Machine machine = MachineManager.get(location);
// Do your stuff
```

Returning machine from configuration.
```java
MachineItem item = MachineItemManager.get(type);
// Do your stuff
```
