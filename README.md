# spring-data-jpa
Spring data JPA ( mapping: OneToMany, ManyToOne, ManyToMany; model first: init DB from model, init data from sql file) 

#

Unfortunately, there are also bad ways of handling the LazyInitializationException like:

+ Open Session in View

+ hibernate.enable_lazy_load_no_trans

These two Anti-Patterns are very inefficient from a database perspective, so you should never use them in your enterprise application.

https://vladmihalcea.com/the-best-way-to-handle-the-lazyinitializationexception/

+ JOIN FETCH to the rescue

+ DTO projection to the rescue