#!/bin/bash

echo "Creating local resources"

echo "Creating dynamodb Customer table"
awslocal dynamodb create-table \
  --table-name Customer \
  --attribute-definitions \
      "AttributeName=id,AttributeType=S" \
  --key-schema \
      "AttributeName=id,KeyType=HASH" \
  --provisioned-throughput \
      "ReadCapacityUnits=5,WriteCapacityUnits=5" \

echo "Creating SQS queue customer-state-queue"
awslocal sqs create-queue --queue-name customer-state-queue \
          --attributes FifoQueue=false,ContenBasedDeduplication=false \
          --endpoint-url=http://localhost:4566