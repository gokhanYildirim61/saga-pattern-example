# Common

Contains technical classes shared by the services, such as `BaseEntity`.

The package structure follows the project convention: `api`, `business`,
`core`, `dataAccess`, `entites`, and `mappers`.

Do not place service-owned domain entities here. Each microservice owns its own
domain model and database boundary.
