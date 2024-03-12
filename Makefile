.PHONY: spotless-apply
spotless-apply:
	mvn spotless:apply

.PHONY: spotless-check
spotless-check:
	mvn spotless:check