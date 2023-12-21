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

echo "Creating SNS topic customer_state_topic"
awslocal sns create-topic --name customer_state_topic \
          --endpoint-url=http://localhost:4566