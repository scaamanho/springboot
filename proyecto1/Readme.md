CustomerControler
* Complete crud rest service


```
	Component <--extends--Service (service)
  		^
  		|--extends--Controller (presentation)
  		|--extends--Repository (persistence)
```

#

|Annotation|Meaning|
|----|----|
|@Component|generic stereotype for any Spring-managed component|
|@Repository|stereotype for persistence layer |
|@Service|stereotype for service layer|
|@Controller|stereotype for presentation layer (spring-mvc)|


