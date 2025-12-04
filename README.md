# Mobile Mart: Inventory Control Hub



## Overview

Mobile Mart Inventory Control Hub is a comprehensive inventory management system aimed at mobile phone retailers, wholesalers, and distributors. This project leverages Java for user interface and business logic and SQL for robust database management, allowing users to efficiently handle purchases, sales, user roles, reports, and payments in a retail store/inventory environment. The platform focuses on modularity, security, ease-of-use, and real-world business requirements.

## Key Features

- **User Management & Security**
  - Login interface, password changes, user creation, account deletion
  - Role-based access for admins and standard users
  - Secure credential storage and access control

- **Item and Inventory Tracking**
  - Add, modify, and remove items for sale or purchase
  - Itemwise details with sorting and filtering
  - Track stock levels, item master, and party master details

- **Sales & Purchase Management**
  - Record and manage sale/purchase transactions
  - Associate sales/purchases with party/accounts
  - Automated reporting and summary pages

- **Comprehensive Reporting**
  - Daily/periodic sales and purchase reports
  - Itemwise, userwise, and party-based analytics
  - Exportable and printable report formats

- **Payment Management**
  - Distributor payment tracking and party management
  - Outward/inward payment reconciliation

- **Database Integration**
  - Full-featured SQL schema for reliability and speed
  - Easy backup, restore, and migration options

- **Intuitive UI Design**
  - Welcome and login pages for a streamlined entry point
  - Multi-page application structure for each major feature
  - Visual cues, icons, and branding for professional look

- **Customization and Scalability**
  - Easily add new features with modular Java classes
  - Designed for integration with future mobile or web extensions

## How It Works

- Users log in via the `Login_page.java` UI, authenticated against the inventory database schema in `inventory_master.sql`.
- Admins manage users, reset/change passwords, and oversee system-wide activity (`Admin.java`, `Create_user.java`, `Drop_user.java`, `Change_password.java`).
- Sales and purchases are recorded with full item and party detail, generating transaction records for future lookup (`Sale_item.java`, `Purchase_item.java`).
- Daily, monthly, itemwise, and party-based reports are handled by dedicated modules (`Sale_reports.java`, `Purchase_reports.java`, `Itemwise_details.java`, `Party_master.java`, `Party_details.java`).
- Payment details and distributor accounts are managed securely via `Dist_payment.java`.

## File Structure and Major Modules

| File Name              | Description                                               |
|------------------------|-----------------------------------------------------------|
| `inventory_master.sql` | Complete database setup and schema                        |
| `Login_page.java`      | User login interface and authentication logic             |
| `Create_user.java`     | Admin user adding functionality                          |
| `Change_password.java` | Secure password creation and change logic                 |
| `Drop_user.java`       | Admin account deletion                                   |
| `User.java`            | User role/entity management                               |
| `Admin.java`           | Admin window and privileged commands                      |
| `Sale_item.java`       | Sale transaction entry and management                     |
| `Purchase_item.java`   | Purchase transaction recording and analysis               |
| `Sale_reports.java`    | Automated sales report generation                         |
| `Purchase_reports.java`| Automated purchase report handling                        |
| `Itemwise_details.java`| Sorting/filtering item details                            |
| `Party_master.java`    | Master list, details, and summary of distributors/parties |
| `Party_details.java`   | Additional party details module                           |
| `Dist_payment.java`    | Distributor payment and payment status module             |
| `Welcome_page.java`    | Initial welcome splash screen and UI navigation           |
| `logo.jpg`, `img1.jpg`, `img2.jpg` | Visual branding and supplementary graphics     |

## Database Design

The included `inventory_master.sql` file defines all necessary tables: users, items, parties, payments, sales, purchases, and audit logs. Referential integrity and transaction safety are ensured using constraints and indexed relationships.

## Learning and Application Outcomes

- Develop secure, scalable retail inventory software using Java and SQL.
- Gain advanced skills in multi-module business applications.
- Understand role-based authentication and user management patterns.
- Experience building CRUD reports, analytics, and reconciliations.
- Practice modern interface design and branding for enterprise settings.
- Prepare for real-world deployment, maintenance, and upgrades.

## How To Use

1. Set up your database using the provided SQL script.
2. Compile Java modules and launch `Login_page.java` or `Welcome_page.java`.
3. Log in as an admin to create/modify users; standard users access permitted modules.
4. Add inventory, record purchases and sales, manage parties and payments.
5. Generate and archive reports for auditing or business strategy.

## Credits

Developed by `Bakshish Kaur`. Inspired by best practices in inventory management and input from mobile retail professionals. Thanks to Java and SQL communities for guidance and code samples.


